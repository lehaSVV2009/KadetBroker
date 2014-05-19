package com.kadet.kadetBroker.dto;

import com.kadet.kadetBroker.entity.Customer;
import com.kadet.kadetBroker.entity.Share;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 19.05.14
 * Time: 12:54
 *
 * @author SarokaA
 */
public class StocksDTO implements DTO {

    private Customer currentCustomer;

    private List<Share> yourShares = new ArrayList<Share>();
    private List<Share> freeShares = new ArrayList<Share>();

    public StocksDTO (Customer currentCustomer, List<Share> yourShares, List<Share> freeShares) {
        this.currentCustomer = currentCustomer;
        this.yourShares = yourShares;
        this.freeShares = freeShares;
    }

    public Customer getCurrentCustomer () {
        return currentCustomer;
    }

    public List<Share> getYourShares () {
        return yourShares;
    }

    public List<Share> getFreeShares () {
        return freeShares;
    }
}
