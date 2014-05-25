package com.kadet.kadetBroker.viewModel;

import com.kadet.kadetBroker.to.CustomerTO;

/**
 * Date: 22.05.14
 * Time: 11:46
 *
 * @author SarokaA
 */
public class CustomerInfoViewModel implements ViewModel {

    private CustomerTO customerTO;

    public CustomerTO getCurrentCustomerTO () {
        return customerTO;
    }

    public void setCustomerTO (CustomerTO customerTO) {
        this.customerTO = customerTO;
    }
}
