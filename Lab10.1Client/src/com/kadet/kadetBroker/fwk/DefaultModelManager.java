package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.to.CustomerTO;
import com.kadet.kadetBroker.to.CustomersListTO;
import com.kadet.kadetBroker.to.PortfolioTO;
import com.kadet.kadetBroker.to.ShareTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 17.05.14
 * Time: 6:25
 *
 * @author SarokaA
 */
public class DefaultModelManager {      

    private final static DefaultModelManager instance = new DefaultModelManager();

    public static DefaultModelManager getInstance () {
        return instance;
    }

    private DefaultModelManager() {}

    public CustomerTO createDefaultCustomerTO () {
        CustomerTO customerTO = new CustomerTO();
        customerTO.setId("");
        customerTO.setName("");
        customerTO.setAddress("");
        return customerTO;
    }

    public CustomersListTO createDefaultCustomersListTO () {
        return new CustomersListTO();
    }

    public PortfolioTO createDefaultPortfolioTO () {
        PortfolioTO portfolioTO = new PortfolioTO();
        portfolioTO.setCustomerTO(createDefaultCustomerTO());
        portfolioTO.setShareTOs(new ArrayList<ShareTO>());
        return portfolioTO;
    }

    /*public List<Customer> createDefaultCustomers () {
        return new ArrayList<Customer>();
    }

    public List<Share> createDefaultShares () {
        return new ArrayList<Share>();
    }

    public Customer createDefaultCustomer () {
        return new Customer();
    } */

}
