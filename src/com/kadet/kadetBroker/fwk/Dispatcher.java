package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.entity.Customer;
import com.kadet.kadetBroker.model.DataModel;

import java.util.List;

/**
 * Date: 16.05.14
 * Time: 5:14
 *
 * @author Кадет
 */
public class Dispatcher {

    private final static Dispatcher instance = new Dispatcher();

    public static Dispatcher getInstance () {
        return instance;
    }

    private Dispatcher() {}

    private DataModel dataModel;

    public void setModel (DataModel dataModel) {
        this.dataModel = dataModel;
    }

    public List<Customer> getAllCustomers () {
        return (List<Customer>)ProxyManager.getInstance().deepClone(dataModel.getAllCustomers());
    }

}
