package com.kadet.kadetBroker.sqlBuilder;

import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.to.CustomerTO;
import com.kadet.kadetBroker.to.TO;
import com.kadet.kadetBroker.util.Strings;

/**
 * Date: 20.05.14
 * Time: 1:17
 *
 * @author Кадет
 */
public class AddCustomerSqlBuilder implements SqlBuilder {

    public String build (TO to) throws KadetException {
        if (to instanceof CustomerTO) {
            CustomerTO customerTO = (CustomerTO) to;
            StringBuilder builder
                    = new StringBuilder()
                    .append("insert into")
                    .append(' ')
                    .append(Strings.CUSTOMERS_TABLE)
                    .append(' ')
                        .append('(')
                        .append(Strings.CUSTOMER_ID)
                        .append(',')
                        .append(Strings.CUSTOMER_NAME)
                        .append(',')
                        .append(Strings.CUSTOMER_ADDRESS)
                        .append(')')
                    .append(' ')
                    .append("values")
                    .append(' ')
                        .append('(')
                        .append("'" + customerTO.getId() + "'")
                        .append(',')
                        .append("'" + customerTO.getName() + "'")
                        .append(',')
                        .append("'" + customerTO.getAddress() + "'")
                        .append(')');
            return builder.toString();
        }
        throw new KadetException(Strings.BAD_TO_OBJECT_FOR_BUILDING_SQL_QUERY);
}

}