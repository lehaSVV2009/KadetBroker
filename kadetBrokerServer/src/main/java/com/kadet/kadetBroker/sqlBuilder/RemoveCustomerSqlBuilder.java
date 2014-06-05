package com.kadet.kadetBroker.sqlBuilder;

import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.to.CustomerTO;
import com.kadet.kadetBroker.to.TO;
import com.kadet.kadetBroker.util.Strings;

/**
 * Date: 20.05.14
 * Time: 14:03
 *
 * @author SarokaA
 */
public class RemoveCustomerSqlBuilder implements SqlBuilder {

    @Override
    public String build (TO to) throws KadetException {
        if (to instanceof CustomerTO) {
            CustomerTO customerTO = (CustomerTO) to;
            return new BuilderUtil(SqlStatementType.DELETE)
                    .from(Strings.CUSTOMERS_TABLE)
                    .where(Strings.CUSTOMER_ID + " = '" + customerTO.getId() + "'").toString();
        }
        throw new KadetException(Strings.BAD_TO_OBJECT_FOR_BUILDING_SQL_QUERY);
    }
}
