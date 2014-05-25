package com.kadet.kadetBroker.command;

import com.kadet.kadetBroker.sqlBuilder.SqlStatementType;

/**
 * Date: 20.05.14
 * Time: 0:46
 *
 * @author Кадет
 */
public class AddCustomerCommand extends AbstractCommand {


    private static final long serialVersionUID = 10L;

    @Override
    public String getDaoName () {
        return "customersDAO";
    }

    @Override
    public String getSqlBuilderName () {
        return "addCustomerSqlBuilder";
    }

    @Override
    public SqlStatementType getSqlStatementType () {
        return SqlStatementType.INSERT;
    }
}
