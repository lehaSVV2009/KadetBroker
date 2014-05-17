package com.kadet.kadetBroker.entity;

import java.io.Serializable;
import java.util.*;

public class Portfolio implements Serializable, Entity {
	
    private Customer customer;
    private List<Share> shares;
    
    public Portfolio(Customer customer, List<Share> shares) {
        this.customer = customer;
        this.shares = shares;
    }
    
    public Portfolio(Customer customer) {
        this.customer = customer;
        this.shares = new ArrayList<Share>(10);
    }
    
    // accessor methods
    public Customer getCustomer(){
        return customer;
    }
    
    public List<Share> getShares(){
        return shares;
    }
    
    // other methods
    // public void addShare(Share s){}    -- should not have this
    // public void removeShare(Share s){} -- should not have this
    // public double getValue() {}  -- should not have this
    // public String toString() {}
    // public boolean equals(Object o) {}
}