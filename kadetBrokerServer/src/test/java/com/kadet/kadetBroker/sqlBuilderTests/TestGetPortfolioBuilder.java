package com.kadet.kadetBroker.sqlBuilderTests;

import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.sqlBuilder.GetPortfolioSqlBuilder;
import com.kadet.kadetBroker.sqlBuilder.SqlBuilder;
import com.kadet.kadetBroker.to.CustomerTO;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Date: 25.05.14
 * Time: 15:35
 *
 * @author SarokaA
 */
public class TestGetPortfolioBuilder {

    @Test
    public void simpleGetPortfolioTest () throws KadetException {

        CustomerTO customerTO = new CustomerTO();
        customerTO.setId("123-123-123");

        SqlBuilder sqlBuilder = new GetPortfolioSqlBuilder();
        String sql = sqlBuilder.build(customerTO);

        Assert.assertEquals("select SHARES.SYMBOL, SHARES.QUANTITY, STOCK.PRICE from CUSTOMER, SHARES, STOCK where CUSTOMER.SSN = \'123-123-123\' and CUSTOMER.SSN = SHARES.SSN and SHARES.SYMBOL = STOCK.SYMBOL", sql);

    }

}
