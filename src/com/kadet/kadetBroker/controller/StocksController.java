package com.kadet.kadetBroker.controller;

import com.kadet.kadetBroker.entity.Customer;
import com.kadet.kadetBroker.entity.Share;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 16.05.14
 * Time: 8:16
 *
 * @author SarokaA
 */
public class StocksController implements Controller {

    private List<Share> freeShares = new ArrayList<Share>();
    private List<Share> yourShares = new ArrayList<Share>();
    private Customer currentCustomer;

    public void setFreeShares (List<Share> freeShares) {
        this.freeShares = freeShares;
    }

    public void setYourShares (List<Share> yourShares) {
        this.yourShares = yourShares;
    }

    public void setCurrentCustomer (Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }
}
