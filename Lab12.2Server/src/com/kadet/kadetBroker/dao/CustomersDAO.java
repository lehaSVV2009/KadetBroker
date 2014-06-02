package com.kadet.kadetBroker.dao;

import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.fwk.DBAnswer;
import com.kadet.kadetBroker.to.CustomerTO;
import com.kadet.kadetBroker.to.CustomersListTO;
import com.kadet.kadetBroker.to.TO;
import com.kadet.kadetBroker.util.Strings;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Date: 20.05.14
 * Time: 1:16
 *
 * @author Кадет
 */
public class CustomersDAO implements DAO {

    @Override
    public TO getTOFromDBAnswer (ResultSet resultSet) throws KadetException {
        CustomersListTO customersListTO = new CustomersListTO();
        List<CustomerTO> customerTOs = new ArrayList<CustomerTO>();
        try {
            while (resultSet.next()) {
                CustomerTO customerTO = new CustomerTO();
                customerTO.setId(resultSet.getString(Strings.CUSTOMER_ID));
                customerTO.setName(resultSet.getString(Strings.CUSTOMER_NAME));
                customerTO.setAddress(resultSet.getString(Strings.CUSTOMER_ADDRESS));
                customerTOs.add(customerTO);
                customersListTO.addCustomerTO(customerTO);
            }
        } catch (SQLException e) {
        	e.printStackTrace();
            throw new KadetException(Strings.BAD_RESULT_SET + ":" + e.getMessage());
        }
        return customersListTO;
    }

}
