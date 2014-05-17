package com.kadet.kadetBroker.entity;

import java.io.Serializable;

public class Customer implements Serializable, Entity {
	
    private String id;
    private String name;
    private String address;
    
    // Constructors
    public Customer(String id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }
    
    public Customer(String id){
        this(id, null, null);
    }
    
    public Customer(){
        this(null, null, null);
    }
    
    // Accesser methods
    public String getId (){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public String getAddress (){
        return address;
    }
    
    // Mutator methods - note you cannot change the id
    public void setName(String newName){
        name = newName;
    }
    
    public void setAddress (String newAddr){
        address = newAddr;
    }
    
    public String toString() {
        return "Customer:  " + id + "  " + name + "  " + address;
    }



}

