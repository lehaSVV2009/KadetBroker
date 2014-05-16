package com.kadet.kadetBroker.entity;

import java.io.Serializable;
import java.util.*;

public class Portfolio implements Serializable {
	
    private Customer cust;
    private ArrayList<Share> shares;
    
    public Portfolio(Customer cust, ArrayList<Share> shares) {
        this.cust = cust;
        this.shares = shares;
    }
    
    public Portfolio(Customer cust) {
        this.cust = cust;
        this.shares = new ArrayList<Share>(10);
    }
    
    // accessor methods
    public Customer getCustomer(){
        return cust;
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