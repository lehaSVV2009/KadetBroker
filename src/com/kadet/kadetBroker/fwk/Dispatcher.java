package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.dto.AddCustomerDTO;
import com.kadet.kadetBroker.dto.UpdateCustomerDTO;
import com.kadet.kadetBroker.entity.Customer;
import com.kadet.kadetBroker.entity.Share;
import com.kadet.kadetBroker.exception.KadetException;
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

    public List<Share> getFreeShares () {
        return (List<Share>)ProxyManager.getInstance().deepClone(dataModel.getFreeShares());
    }

    public List<Share> getCustomerShares (Customer customer) throws KadetException {
        return dataModel.getCustomerShares(customer);
    }

    public List<Customer> getDefaultAllCustomers () {
        return DefaultModelManager.getInstance().createDefaultCustomers();
    }

    public List<Share> getDefaultFreeShares () {
        return DefaultModelManager.getInstance().createDefaultShares();
    }

    public List<Share> getDefaultYourShares () {
        return DefaultModelManager.getInstance().createDefaultShares();
    }

    public Customer getDefaultCustomer () {
        return DefaultModelManager.getInstance().createDefaultCustomer();
    }




    public void addCustomer (AddCustomerDTO addCustomerDTO) {
        Customer customer = addCustomerDTO.getCustomer();
        dataModel.addCustomer(customer);
        ViewManager.getInstance().notifyPropertyChange(PropertyChangingType.REFRESH_CUSTOMER_LIST, customer);
    }

    public void updateCustomer (UpdateCustomerDTO updateCustomerDTO) {
        Customer customer = updateCustomerDTO.getNewCustomer();
        dataModel.updateCustomer(customer);
        ViewManager.getInstance().notifyPropertyChange(PropertyChangingType.REFRESH_CUSTOMER_LIST, customer);
        ViewManager.getInstance().notifyPropertyChange(PropertyChangingType.CURRENT_CUSTOMER_CHANGING, customer);
    }



}
