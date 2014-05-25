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
public class UpdateCustomerSqlBuilder implements SqlBuilder {
    @Override
    public String build (TO to) throws KadetException {
        if (to instanceof CustomerTO) {
            CustomerTO customerTO = (CustomerTO) to;
            StringBuilder builder
                    = new StringBuilder()
                    .append("update")
                    .append(' ')
                    .append(Strings.CUSTOMERS_TABLE)
                    .append(' ')
                    .append("SET")
                    .append(' ')
                    .append(Strings.CUSTOMER_NAME + " = ")
                    .append("'" + customerTO.getName() + "'")
                    .append(',')
                    .append(Strings.CUSTOMER_ADDRESS + " = ")
                    .append("'" + customerTO.getAddress() + "'")
                    .append(' ')
                    .append("where")
                    .append(' ')
                    .append(Strings.CUSTOMER_ID + " = ")
                    .append("'" + customerTO.getId() + "'")
                    /*.append(';')*/;
            return builder.toString();
        }
        throw new KadetException(Strings.BAD_TO_OBJECT_FOR_BUILDING_SQL_QUERY);
    }
}