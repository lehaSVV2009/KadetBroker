package com.kadet.kadetBroker.viewModel;

import com.kadet.kadetBroker.to.CustomerTO;

/**
 * Date: 22.05.14
 * Time: 4:03
 *
 * @author SarokaA
 */
public class UpdateCustomerViewModel implements ViewModel {

    private CustomerTO oldCustomerTO;

    private CustomerTO newCustomerTO;

    public CustomerTO getNewCustomerTO () {
        return newCustomerTO;
    }

    public void setNewCustomerTO (CustomerTO newCustomerTO) {
        this.newCustomerTO = newCustomerTO;
    }

    public CustomerTO getOldCustomerTO () {
        return oldCustomerTO;
    }

    public void setOldCustomerTO (CustomerTO oldCustomerTO) {
        this.oldCustomerTO = oldCustomerTO;
    }
}
