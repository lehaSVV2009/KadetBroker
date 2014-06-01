package com.kadet.kadetBroker.command;

import java.rmi.RemoteException;

import com.kadet.kadetBroker.sqlBuilder.SqlStatementType;

/**
 * Date: 20.05.14
 * Time: 0:58
 *
 * @author Кадет
 */
public class GetAllCustomersCommand extends AbstractCommand {

	public GetAllCustomersCommand() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 11L;

    @Override
    public String getDaoName () {
        return "customersDAO";
    }

    @Override
    public String getSqlBuilderName () {
        return "getAllCustomersSqlBuilder";
    }

    @Override
    public SqlStatementType getSqlStatementType () {
        return SqlStatementType.SELECT;
    }


}
