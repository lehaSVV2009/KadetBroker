package com.kadet.kadetBroker.command;

import com.kadet.kadetBroker.dao.DAO;
import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.fwk.*;
import com.kadet.kadetBroker.session.Session;
import com.kadet.kadetBroker.session.SessionCacheItem;
import com.kadet.kadetBroker.sqlBuilder.SqlBuilder;
import com.kadet.kadetBroker.sqlBuilder.SqlStatementType;
import com.kadet.kadetBroker.to.SystemTO;
import com.kadet.kadetBroker.to.TO;
import com.kadet.kadetBroker.transaction.SqlOperation;
import com.kadet.kadetBroker.transaction.TransactionManager;
import com.kadet.kadetBroker.util.Strings;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Date: 20.05.14
 * Time: 16:29
 *
 * @author SarokaA
 */
public abstract class AbstractCommand extends UnicastRemoteObject implements Command {


    private static Logger logger = Logger.getLogger(AbstractCommand.class.getName());

    protected AbstractCommand() throws RemoteException {
        super();
    }

    protected KadetException exception;
    protected SystemTO systemTO;
    protected TO to;

    abstract public String getDaoName();

    abstract public String getSqlBuilderName();

    @Override
    public void execute() throws RemoteException {

        logger.log(Level.INFO, Strings.START_TO_EXECUTE_COMMAND + ": " + getClass().getName());

        ServerPropertiesManager propertiesManager = ServerPropertiesManager.getInstance();
        SqlBuilderManager sqlBuilderManager = SqlBuilderManager.getInstance();
        SessionManager sessionManager = SessionManager.getInstance();
        TransactionContainer transactionContainer = TransactionContainer.getInstance();
        String macAddress = systemTO.getMacAddress();

        TO toFrom = to;

        try {

            // Get SQL Builder
            String sqlBuilderClassName
                    = propertiesManager.getSqlBuilderClassNameByVariable(getSqlBuilderName());
            SqlBuilder sqlBuilder = sqlBuilderManager.getSqlBuilder(sqlBuilderClassName);

            preBuildSql(sqlBuilder, toFrom);

            // Build SQL String
            String sqlRequest
                    = sqlBuilder.build(toFrom);
            logger.log(Level.INFO, Strings.SQL_REQUEST + sqlRequest);

            preExecutingSql(SqlEngine.getInstance(), sqlRequest);

            // Session
            Session session = sessionManager.getSession(systemTO.getMacAddress());
            if (session == null) {
                session = sessionManager.newClientSession(macAddress);
            }

            TO result = session.getLastRequestResult(sqlRequest);
            if (result != null) {
                this.to = result;
            } else {

                // Transaction
                TransactionManager transactionManager = transactionContainer.getTransaction(macAddress);
                if (transactionManager == null) {
                    transactionManager = transactionContainer.newClientTransaction(macAddress);
                }

                SqlOperation sqlOperation = new SqlOperation(sqlRequest, getSqlStatementType());
                // Execute SQL
                DBAnswer dbAnswer
                        = transactionManager.executeTransaction(sqlOperation);

                preDAOAnswerBuilding(dbAnswer);

                // Transform Transaction to answer
                if (dbAnswer.hasResultSet()) {
                    String daoClassName
                            = ServerPropertiesManager.getInstance().getDAOClassNameByVariable(getDaoName());
                    DAO dao = DAOManager.getInstance().getDAO(daoClassName);
                    TO resultTO = dao.getTOFromDBAnswer(dbAnswer.getResultSet());
                    to = resultTO;
                } else if (dbAnswer.getResult() == 0) {
                    throw new KadetException(Strings.OPERATION_ERROR);
                }

                session.addSessionCacheItem(new SessionCacheItem(sqlRequest, to, Calendar.getInstance().getTime()));

            }

            preAnswerSending(toFrom, to);

            logger.log(Level.INFO, Strings.RESULT_TO + to);

        } catch (KadetException e) {
            this.exception = e;
            logger.log(Level.SEVERE, Strings.COMMAND_HAS_FAILED, e);
        }

    }

    @Override
    public void setTO(TO to) throws RemoteException {
        this.to = to;
    }

    @Override
    public TO getResult() throws RemoteException {
        return to;
    }

    @Override
    public void setSystemTO(SystemTO systemTO) throws RemoteException {
        this.systemTO = systemTO;
    }

    @Override
    public KadetException getException() throws RemoteException {
        return exception;
    }

    abstract public SqlStatementType getSqlStatementType();


    protected void preBuildSql(SqlBuilder sqlBuilder, TO to) {

    }

    protected void preExecutingSql(SqlEngine sqlEngine, String sql) {

    }

    protected void preDAOAnswerBuilding(DBAnswer dbAnswer) {

    }

    protected void preAnswerSending(TO request, TO answer) {

    }

}
