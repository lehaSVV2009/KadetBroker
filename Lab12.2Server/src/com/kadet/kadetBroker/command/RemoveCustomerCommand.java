package com.kadet.kadetBroker.command;

import java.rmi.RemoteException;

import com.kadet.kadetBroker.sqlBuilder.SqlStatementType;

/**
 * Date: 20.05.14
 * Time: 16:18
 *
 * @author SarokaA
 */
public class RemoveCustomerCommand extends AbstractCommand {

	public RemoveCustomerCommand() throws RemoteException {
	}

    @Override
    public String getDaoName () {
        return "customersDAO";
    }

    @Override
    public String getSqlBuilderName () {
        return "removeCustomerSqlBuilder";
    }

    @Override
    public SqlStatementType getSqlStatementType () {
        return SqlStatementType.DELETE;
    }
}
