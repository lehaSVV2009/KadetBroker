package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.model.DataModel;
import com.kadet.kadetBroker.to.*;
import com.kadet.kadetBroker.viewModel.AddCustomerViewModel;
import com.kadet.kadetBroker.viewModel.AllCustomersViewModel;
import com.kadet.kadetBroker.viewModel.StocksViewModel;
import com.kadet.kadetBroker.viewModel.UpdateCustomerViewModel;

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

    private ProxyManager proxyManager = ProxyManager.getInstance();
    private DefaultModelManager defaultModelManager = DefaultModelManager.getInstance();

    private DataModel dataModel;

    private ViewManager viewManager = ViewManager.getInstance();

    /**
     *  GetAllCustomersCommand
     *
     * @param customersListTO
     */
    public void setCustomerTOs (CustomersListTO customersListTO) {
        dataModel.setCustomerTOs(customersListTO.getCustomerTOsList());
        for (CustomerTO customerTO : customersListTO.getCustomerTOsList()) {
            viewManager.notifyByObjectChanged(customerTO);
        }
    }

    /**
     *  UpdateCustomerCommand
     *
     * @param customerTO
     */
    public void updateCustomerTO (CustomerTO customerTO) {
        dataModel.updateCustomerTO(customerTO);
        viewManager.notifyByObjectChanged(customerTO);
        viewManager.notifyByCurrentCustomer(getDefaultCustomerTO());
    }


    /**
     *  RemoveCustomerCommand
     *
     * @param customerTO
     */
    public void removeCustomerTO (CustomerTO customerTO) {
        dataModel.removeCustomerTO(customerTO);
        viewManager.notifyByObjectChanged(customerTO);
        viewManager.notifyByCurrentCustomer(getDefaultCustomerTO());
    }



    /**
     *  AddCustomerCommand
     *
     * @param customerTO
     */
    public void addCustomerTO (CustomerTO customerTO) {
        dataModel.addCustomerTO(customerTO);
        viewManager.notifyByObjectChanged(customerTO);
        viewManager.notifyByCurrentCustomer(getDefaultCustomerTO());
    }


    public void setStockTOs (StocksListTO stocksListTO) {
        dataModel.setStockTOs(stocksListTO.getStockTOs());
        for (StockTO stockTO : stocksListTO.getStockTOs()) {
            viewManager.notifyByObjectChanged(stockTO);
        }
    }



    public void addPortfolioTO (PortfolioTO portfolioTO) {
        dataModel.addPortfolioTO(portfolioTO);
    }





    public CustomerTO getDefaultCustomerTO () {
        return defaultModelManager.createDefaultCustomerTO();
    }

    public CustomersListTO getDefaultCustomersListTO () {
        return defaultModelManager.createDefaultCustomersListTO();
    }


    public PortfolioTO getDefaultPortfolioTO () {
        return defaultModelManager.createDefaultPortfolioTO();
    }

    public ShareTO getDefaultShareTO () {
        return defaultModelManager.createDefaultShareTO();
    }


    /**
     *  For AllCustomersView
     */
    public boolean hasAllCustomersInModel () {
        return dataModel != null && dataModel.getCustomerTOs() != null && dataModel.getCustomerTOs().size() != 0;
    }

    public AllCustomersViewModel getAllCustomersViewModel () {
        AllCustomersViewModel viewModel = new AllCustomersViewModel();
        for (CustomerTO customerTO : dataModel.getCustomerTOs()) {
            viewModel.addCustomerTO(customerTO);
        }
        viewModel.setCurrentCustomerTO(getDefaultCustomerTO());
        return viewModel;
    }

    public AllCustomersViewModel getDefaultAllCustomersViewModel () {
        AllCustomersViewModel viewModel = new AllCustomersViewModel();
        viewModel.setCurrentCustomerTO(getDefaultCustomerTO());
        return viewModel;
    }

    /**
     *  For StocksView
     */

    public boolean hasAllStocksInModel () {
        return dataModel != null && dataModel.getStockTOs() != null && dataModel.getStockTOs().size() != 0;
    }

    public StocksViewModel getStocksViewModel () {
        StocksViewModel stocksViewModel = new StocksViewModel();
        for (StockTO stockTO : dataModel.getStockTOs()) {
            stocksViewModel.addStock(stockTO);
        }
        stocksViewModel.setPortfolioTO(getDefaultPortfolioTO());
        return stocksViewModel;
    }

    public StocksViewModel getDefaultStocksViewModel () {
        StocksViewModel viewModel = new StocksViewModel();
        viewModel.setPortfolioTO(getDefaultPortfolioTO());
        viewModel.setShareTOForBuying(getDefaultShareTO());
        viewModel.setShareTOForSelling(getDefaultShareTO());
        return viewModel;
    }

    public boolean hasPortfolioOfCustomer (CustomerTO customerTO) {
        return dataModel.getPortfolioTO(customerTO) != null;
    }

    public PortfolioTO getPortfolioTO (CustomerTO customerTO) {
        return dataModel.getPortfolioTO(customerTO);
    }







    public AddCustomerViewModel getDefaultAddCustomerViewModel () {
        AddCustomerViewModel viewModel = new AddCustomerViewModel();
        viewModel.setNewCustomerTO(getDefaultCustomerTO());
        return viewModel;
    }

    public UpdateCustomerViewModel getDefaultUpdateCustomerViewModel () {
        UpdateCustomerViewModel viewModel = new UpdateCustomerViewModel();
        viewModel.setNewCustomerTO(getDefaultCustomerTO());
        viewModel.setOldCustomerTO(getDefaultCustomerTO());
        return viewModel;
    }

    //TODO:
    //public AllCustomersViewModel getAllCustomersViewModel () {
    //  proxyManager...
    //}

    public void setModel (DataModel dataModel) {
        this.dataModel = dataModel;
    }
  /*
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




    public void addCustomer (CustomerTO customerDTO) {
        //Customer customer = customerDTO.getCustomer();
        //dataModel.addCustomer(customer);
        //ViewManager.getInstance().notifyPropertyChange(PropertyChangingType.REFRESH_CUSTOMER_LIST, customer);
    }

    public void updateCustomer (UpdateCustomerDTO updateCustomerDTO) {
        Customer customer = updateCustomerDTO.getNewCustomer();
        dataModel.updateCustomer(customer);
        ViewManager.getInstance().notifyPropertyChange(PropertyChangingType.REFRESH_CUSTOMER_LIST, null);
        ViewManager.getInstance().notifyPropertyChange(PropertyChangingType.CURRENT_CUSTOMER_CHANGING, getDefaultCustomerTO());
    }

    public void removeCustomer (CustomerTO customerDTO) {
        //Customer customer = customerDTO.getCustomer();
        //dataModel.removeCustomer(customer);
        ViewManager.getInstance().notifyPropertyChange(PropertyChangingType.REFRESH_CUSTOMER_LIST, null);
        ViewManager.getInstance().notifyPropertyChange(PropertyChangingType.CURRENT_CUSTOMER_CHANGING, getDefaultCustomerTO());
    }
              */

}
