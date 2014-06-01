package com.kadet.kadetBroker.transaction;

import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.fwk.DBAnswer;
import com.kadet.kadetBroker.fwk.SqlEngine;
import com.kadet.kadetBroker.sqlBuilder.SqlStatementType;
import com.kadet.kadetBroker.util.Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Date: 31.05.14
 * Time: 19:09
 *
 * @author SarokaA
 */
public class ClientTransactionManager implements TransactionManager {

    private static Logger logger = Logger.getLogger(ClientTransactionManager.class.getName());

    private List<SqlOperation> transaction = new ArrayList<SqlOperation>();

    public DBAnswer executeTransaction (SqlOperation sqlOperation) throws KadetException {
        return SqlEngine.getInstance().execute(sqlOperation.getSql(), sqlOperation.getSqlStatementType());
    }

   /* @Override
    public void addSqlOperation(SqlOperation sqlOperation) {
        transaction.add(sqlOperation);
    }

    @Override
    public List<DBAnswer> executeOperations() {
        List<DBAnswer> dbAnswers = new ArrayList<DBAnswer>();

        for (int operationIndex = 0; operationIndex < transaction.size(); ++operationIndex) {

            SqlOperation sqlOperation = transaction.get(operationIndex);

            try {

                DBAnswer dbAnswer = SqlEngine.getInstance().execute(sqlOperation);
                dbAnswers.add(dbAnswer);
                if (!dbAnswer.hasResultSet() && dbAnswer.getResult() == 0) {

                    List<SqlOperation> operationsForRollback = new ArrayList<SqlOperation>();
                    for (int indexForRollback = operationIndex - 1; indexForRollback >= 0; --indexForRollback) {
                        operationsForRollback.add(transaction.get(indexForRollback));
                    }
                    rollbackSqlOperations(operationsForRollback);
                }

            } catch (KadetException e) {

                logger.log(Level.SEVERE, Strings.CAN_NOT_EXECUTE_SQL, e);

                List<SqlOperation> operationsForRollback = new ArrayList<SqlOperation>();
                for (int indexForRollback = 0; indexForRollback <operationIndex; ++indexForRollback) {
                    operationsForRollback.add(transaction.get(indexForRollback));
                }
                rollbackSqlOperations(operationsForRollback);

            }
        }

        transaction.clear();
        return dbAnswers;
    }

    public void rollbackSqlOperations (List<SqlOperation> sqlOperations) {
        for (SqlOperation sqlOperation : sqlOperations) {
            try {
                SqlEngine.getInstance().execute(reverseOperation(sqlOperation));
            } catch (KadetException e) {
                logger.log(Level.SEVERE, Strings.CAN_NOT_EXECUTE_SQL, e);
            }
        }
    }

    public SqlOperation reverseOperation (SqlOperation sqlOperation) {
        switch (sqlOperation.getSqlStatementType()) {
            case SELECT : {
                return new SqlOperation("", SqlStatementType.SELECT);
            }
            case INSERT : {
                return new SqlOperation("", SqlStatementType.SELECT);
            }
            case DELETE : {
                return new SqlOperation("", SqlStatementType.SELECT);
            }
            case UPDATE : {
                return new SqlOperation("", SqlStatementType.SELECT);
            }
            default : {
                return new SqlOperation("", SqlStatementType.SELECT);
            }

        }
    }

    */


}
