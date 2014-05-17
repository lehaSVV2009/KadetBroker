package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.entity.Customer;
import com.kadet.kadetBroker.entity.Share;

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

    public List<Customer> createDefaultCustomers () {
        return new ArrayList<Customer>();
    }

    public List<Share> createDefaultShares () {
        return new ArrayList<Share>();
    }

    public Customer createDefaultCustomer () {
        return new Customer();
    }

}
