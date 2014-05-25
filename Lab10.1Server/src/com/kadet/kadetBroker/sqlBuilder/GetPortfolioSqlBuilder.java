package com.kadet.kadetBroker.sqlBuilder;

import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.to.CustomerTO;
import com.kadet.kadetBroker.to.TO;
import com.kadet.kadetBroker.util.Strings;

/**
 * Date: 25.05.14
 * Time: 15:05
 *
 * @author SarokaA
 */
public class GetPortfolioSqlBuilder implements SqlBuilder {

    @Override
    public String build (TO to) throws KadetException {
        if (to instanceof CustomerTO) {
            CustomerTO customerTO = (CustomerTO) to;
            return new BuilderUtil(SqlStatementType.SELECT)
                    .column(Strings.SHARES_TABLE + '.' + Strings.SHARE_SYMBOL)
                    .column(Strings.SHARES_TABLE + '.' + Strings.SHARE_QUANTITY)
                    .column(Strings.STOCKS_TABLE + '.' + Strings.STOCK_PRICE)
                    .from(Strings.CUSTOMERS_TABLE)
                    .from(Strings.SHARES_TABLE)
                    .from(Strings.STOCKS_TABLE)
                    .where(Strings.CUSTOMERS_TABLE + '.' + Strings.CUSTOMER_ID +
                            " = " + "'" + customerTO.getId() + "'")
                    .where(Strings.CUSTOMERS_TABLE + '.' + Strings.CUSTOMER_ID +
                            " = " + Strings.SHARES_TABLE + '.' + Strings.SHARE_SSN)
                    .where(Strings.SHARES_TABLE + '.' + Strings.SHARE_SYMBOL +
                            " = " + Strings.STOCKS_TABLE + '.' + Strings.STOCK_ID)
                    .toString();
        }
        throw new KadetException(Strings.BAD_TO_OBJECT_FOR_BUILDING_SQL_QUERY);
    }
}
