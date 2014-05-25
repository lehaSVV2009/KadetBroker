package com.kadet.kadetBroker.viewModel;

import com.kadet.kadetBroker.to.CustomerTO;
import com.kadet.kadetBroker.to.CustomersListTO;

/**
 * Date: 22.05.14
 * Time: 4:02
 *
 * @author SarokaA
 */
public class AddCustomerViewModel implements ViewModel {

    private CustomerTO newCustomerTO;

    public CustomerTO getNewCustomerTO () {
        return newCustomerTO;
    }

    public void setNewCustomerTO (CustomerTO newCustomerTO) {
        this.newCustomerTO = newCustomerTO;
    }
}
