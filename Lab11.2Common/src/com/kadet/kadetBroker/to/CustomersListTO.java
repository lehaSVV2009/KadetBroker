package com.kadet.kadetBroker.to;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 22.05.14
 * Time: 0:36
 *
 * @author SarokaA
 */
public class CustomersListTO implements TO {

    private List<CustomerTO> customerTOsList = new ArrayList<CustomerTO>();

    public List<CustomerTO> getCustomerTOsList () {
        return customerTOsList;
    }

    public void addCustomerTO (CustomerTO customerTO) {
        customerTOsList.add(customerTO);
    }

    @Override
    public String toString () {
        return "CustomersListTO{" +
                "customerTOsList=" + customerTOsList +
                '}';
    }

}
