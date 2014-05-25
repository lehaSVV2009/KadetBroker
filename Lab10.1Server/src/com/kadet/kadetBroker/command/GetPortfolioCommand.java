package com.kadet.kadetBroker.command;

import com.kadet.kadetBroker.sqlBuilder.SqlStatementType;
import com.kadet.kadetBroker.to.CustomerTO;
import com.kadet.kadetBroker.to.PortfolioTO;
import com.kadet.kadetBroker.to.TO;

/**
 * Date: 25.05.14
 * Time: 14:22
 *
 * @author SarokaA
 */
public class GetPortfolioCommand extends AbstractCommand {

    private static final long serialVersionUID = 15L;

    @Override
    public String getDaoName () {
        return "portfolioDAO";
    }

    @Override
    public String getSqlBuilderName () {
        return "getPortfolioSqlBuilder";
    }

    @Override
    public SqlStatementType getSqlStatementType () {
        return SqlStatementType.SELECT;
    }

    @Override
    protected void preAnswerSending (TO request, TO answer) {
        CustomerTO customerTO = (CustomerTO) request;
        PortfolioTO portfolioTo = (PortfolioTO) answer;
        portfolioTo.setCustomerTO(customerTO);
    }
}
