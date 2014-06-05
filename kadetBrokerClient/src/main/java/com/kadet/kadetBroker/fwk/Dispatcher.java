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
            CustomerTO customerTOCopy = (CustomerTO) proxyManager.deepClone(customerTO);
            viewManager.notifyByObjectChanged(customerTOCopy);
        }
    }

    /**
     *  UpdateCustomerCommand
     *
     * @param customerTO
     */
    public void updateCustomerTO (CustomerTO customerTO) {
        dataModel.updateCustomerTO(customerTO);
        CustomerTO customerTOCopy
                = (CustomerTO) proxyManager.deepClone(customerTO);
        viewManager.notifyByObjectChanged(customerTOCopy);
        viewManager.notifyByCurrentCustomer(getDefaultCustomerTO());
    }


    /**
     *  RemoveCustomerCommand
     *
     * @param customerTO
     */
    public void removeCustomerTO (CustomerTO customerTO) {
        dataModel.removeCustomerTO(customerTO);
        CustomerTO customerTOCopy
                = (CustomerTO) proxyManager.deepClone(customerTO);
        viewManager.notifyByObjectChanged(customerTOCopy);
        viewManager.notifyByCurrentCustomer(getDefaultCustomerTO());
    }



    /**
     *  AddCustomerCommand
     *
     * @param customerTO
     */
    public void addCustomerTO (CustomerTO customerTO) {
        dataModel.addCustomerTO(customerTO);
        CustomerTO customerTOCopy
                = (CustomerTO) proxyManager.deepClone(customerTO);
        viewManager.notifyByObjectChanged(customerTOCopy);
        viewManager.notifyByCurrentCustomer(getDefaultCustomerTO());
    }


    public void setStockTOs (StocksListTO stocksListTO) {
        dataModel.setStockTOs(stocksListTO.getStockTOs());
        for (StockTO stockTO : stocksListTO.getStockTOs()) {
            StockTO stockTOCopy = (StockTO) proxyManager.deepClone(stockTO);
            viewManager.notifyByObjectChanged(stockTOCopy);
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
            CustomerTO customerTOCopy
                    = (CustomerTO) proxyManager.deepClone(customerTO);
            viewModel.addCustomerTO(customerTOCopy);
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
            StockTO stockTOCopy
                    = (StockTO) proxyManager.deepClone(stockTO);
            stocksViewModel.addStock(stockTOCopy);
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
        PortfolioTO portfolioTO = dataModel.getPortfolioTO(customerTO);
        PortfolioTO portfolioTOCopy
                = (PortfolioTO) proxyManager.deepClone(portfolioTO);
        return portfolioTOCopy;
    }


    /**
     *  For AddCustomerView
     */
    public AddCustomerViewModel getDefaultAddCustomerViewModel () {
        AddCustomerViewModel viewModel = new AddCustomerViewModel();
        viewModel.setNewCustomerTO(getDefaultCustomerTO());
        return viewModel;
    }


    /**
     *  For UpdateCustomerView
     */
    public UpdateCustomerViewModel getDefaultUpdateCustomerViewModel () {
        UpdateCustomerViewModel viewModel = new UpdateCustomerViewModel();
        viewModel.setNewCustomerTO(getDefaultCustomerTO());
        viewModel.setOldCustomerTO(getDefaultCustomerTO());
        return viewModel;
    }


    public void setModel (DataModel dataModel) {
        this.dataModel = dataModel;
    }

}
