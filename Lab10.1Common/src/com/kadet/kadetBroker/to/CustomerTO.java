package com.kadet.kadetBroker.to;

/**
 * Date: 22.05.14
 * Time: 0:34
 *
 * @author SarokaA
 */
public class CustomerTO implements TO, Entity<String> {

    private String id;
    private String name;
    private String address;

    public CustomerTO () {
    }

    public void setId (String id) {
        this.id = id;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public String getId () {
        return id;
    }

    public String getName () {
        return name;
    }

    public String getAddress () {
        return address;
    }

}
