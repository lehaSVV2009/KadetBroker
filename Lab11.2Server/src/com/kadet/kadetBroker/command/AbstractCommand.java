package com.kadet.kadetBroker.command;

import com.kadet.kadetBroker.dao.DAO;
import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.fwk.*;
import com.kadet.kadetBroker.sqlBuilder.SqlBuilder;
import com.kadet.kadetBroker.sqlBuilder.SqlStatementType;
import com.kadet.kadetBroker.to.TO;
import com.kadet.kadetBroker.util.Strings;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;

/**
 * Date: 20.05.14
 * Time: 16:29
 *
 * @author SarokaA
 */
public abstract class AbstractCommand extends UnicastRemoteObject implements Command {

    protected AbstractCommand() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;

    protected KadetException exception;

    protected TO toServer;
    protected TO fromServer;

    abstract public String getDaoName ();

    abstract public String getSqlBuilderName ();

    @Override
    public void execute () throws RemoteException {

    	try {
            System.out.println("Server. TO from Client: " + toServer);

            String sqlBuilderClassName
                    = ServerPropertiesManager.getInstance().getSqlBuilderClassNameByVariable(getSqlBuilderName());
            SqlBuilder sqlBuilder
                    = SqlBuilderManager.getInstance().getSqlBuilder(sqlBuilderClassName);

            preBuildSql(sqlBuilder, toServer);

            String sqlRequest
                    = sqlBuilder.build(toServer);
            System.out.println("SqlRequest:" + sqlRequest);

            preExecutingSql(SqlEngine.getInstance(), sqlRequest);

            DBAnswer dbAnswer
                    = SqlEngine.getInstance().execute(sqlRequest, getSqlStatementType());

            preDAOAnswerBuilding(dbAnswer);

            if (dbAnswer.hasResultSet()) {
            	String daoClassName
                        = ServerPropertiesManager.getInstance().getDAOClassNameByVariable(getDaoName());
                DAO dao = DAOManager.getInstance().getDAO(daoClassName);
                TO resultTO = dao.getTOFromDBAnswer(dbAnswer.getResultSet());
                System.out.println("Result TO: " + resultTO);
                fromServer = resultTO;
            } else if (dbAnswer.getResult() > 0) {
                fromServer = toServer;
            } else {
                throw new KadetException(Strings.OPERATION_ERROR);
            }

            preAnswerSending(toServer, fromServer);

        } catch (KadetException e) {
            this.exception = e;
        }

    }

    @Override
    public void setTO(TO to) throws RemoteException {
    	this.toServer = to;
    };
    
    @Override
    public TO getResult () {
        return fromServer;
    }

    abstract public SqlStatementType getSqlStatementType ();


    protected void preBuildSql (SqlBuilder sqlBuilder, TO to) {

    }

    protected void preExecutingSql (SqlEngine sqlEngine, String sql) {

    }

    protected void preDAOAnswerBuilding (DBAnswer dbAnswer) {

    }

    protected void preAnswerSending (TO request, TO answer) {

    }


}
