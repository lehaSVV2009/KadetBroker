package com.kadet.kadetBroker.command;

import com.kadet.kadetBroker.sqlBuilder.SqlStatementType;

/**
 * Date: 20.05.14
 * Time: 16:19
 *
 * @author SarokaA
 */
public class UpdateCustomerCommand extends AbstractCommand {

    private static final long serialVersionUID = 13L;

    @Override
    public String getDaoName () {
        return "customersDAO";
    }

    @Override
    public String getSqlBuilderName () {
        return "updateCustomerSqlBuilder";
    }

    @Override
    public SqlStatementType getSqlStatementType () {
        return SqlStatementType.UPDATE;
    }
}
