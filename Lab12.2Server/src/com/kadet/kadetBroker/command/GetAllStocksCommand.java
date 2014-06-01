package com.kadet.kadetBroker.command;

import java.rmi.RemoteException;

import com.kadet.kadetBroker.sqlBuilder.SqlStatementType;

/**
 * Date: 22.05.14
 * Time: 14:15
 *
 * @author SarokaA
 */
public class GetAllStocksCommand extends AbstractCommand {

	public GetAllStocksCommand() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 14L;

    @Override
    public String getDaoName () {
        return "stocksDAO";
    }

    @Override
    public String getSqlBuilderName () {
        return "getAllStocksSqlBuilder";
    }

    @Override
    public SqlStatementType getSqlStatementType () {
        return SqlStatementType.SELECT;
    }

}
