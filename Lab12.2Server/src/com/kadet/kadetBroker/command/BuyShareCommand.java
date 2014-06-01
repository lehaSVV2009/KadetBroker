package com.kadet.kadetBroker.command;

import java.rmi.RemoteException;

import com.kadet.kadetBroker.sqlBuilder.SqlStatementType;

/**
 * Date: 26.05.14
 * Time: 15:36
 *
 * @author SarokaA
 */
public class BuyShareCommand extends AbstractCommand {

	public BuyShareCommand() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 16L;


    @Override
    public String getDaoName () {
        return null;
    }

    @Override
    public String getSqlBuilderName () {
        return null;
    }

    @Override
    public SqlStatementType getSqlStatementType () {
        return null;
    }
}
