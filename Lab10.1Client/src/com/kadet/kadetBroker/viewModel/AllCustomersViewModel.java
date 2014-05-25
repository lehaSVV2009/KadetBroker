package com.kadet.kadetBroker.viewModel;

import com.kadet.kadetBroker.to.CustomerTO;
import com.kadet.kadetBroker.to.CustomersListTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 22.05.14
 * Time: 3:38
 *
 * @author SarokaA
 */
public class AllCustomersViewModel implements ViewModel {

    private List<CustomerTO> customersListTO = new ArrayList<CustomerTO>();
    private CustomerTO customerTO;

    public void addCustomerTO (CustomerTO customerTO) {
        customersListTO.add(customerTO);
    }

    public List<CustomerTO> getCustomersListTO () {
        return customersListTO;
    }

    public CustomerTO getCurrentCustomerTO () {
        return customerTO;
    }

    public void setCurrentCustomerTO (CustomerTO customerTO) {
        this.customerTO = customerTO;
    }
}
