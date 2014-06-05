package com.kadet.kadetBroker;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.kadet.kadetBroker.command.Command;
import com.kadet.kadetBroker.controller.AllCustomersController;
import com.kadet.kadetBroker.controller.StocksController;
import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.fwk.*;
import com.kadet.kadetBroker.model.DataModel;
import com.kadet.kadetBroker.to.CustomerTO;
import com.kadet.kadetBroker.to.CustomersListTO;
import com.kadet.kadetBroker.to.StocksListTO;
import com.kadet.kadetBroker.rmi.RMIUtils;
import com.kadet.kadetBroker.util.Strings;
import com.kadet.kadetBroker.view.AllCustomersView;
import com.kadet.kadetBroker.view.BrokerFrame;
import com.kadet.kadetBroker.view.CustomerInfoView;
import com.kadet.kadetBroker.view.StocksView;
import com.kadet.kadetBroker.viewModel.AllCustomersViewModel;
import com.kadet.kadetBroker.viewModel.CustomerInfoViewModel;
import com.kadet.kadetBroker.viewModel.StocksViewModel;

/**
 * Date: 22.05.14
 * Time: 1:41
 *
 * @author SarokaA
 */
public class AppBundle {

    private static Logger logger = Logger.getLogger(AppBundle.class.getName());

    public AppBundle() {

        // init static viewModel Properties

        // init Model
        // request CopyModel from Model (request "getAllCustomers")
        // if there is no smth in Model get this from Server and update Model
        // if there is no smth in Model now than add new View "There is no data" or add free View without data
        // init CopyModel for AllCustomersView (List<Customer>)
        // init AllCustomersView (inside - add it to the ViewManager. init with copyModel)
        // init AllCustomersController (inside - add it to the ControllerManager. init with allCustomers)

        // init CustomerInfoView (inside - add it to the ViewManager)

        // request CopyModel from Model (request "getAllShares(currentCustomer)")
        // if there is no smth in Model get this from Server and update Model
        // if there is no smth in Model now than add new View "There is no data" or add free View without data
        // init CopyModel for Shares (List<Share>)
        // request CopyModel from Model (request "getCustomerShares(currentCustomer)")
        // if there is no smth in Model get this from Server and update Model
        // if there is no smth in Model now than add new View "There is no data" or add free View without data
        // init CopyModel for Shares (List<Share>)
        // init SharesView (inside - add it to the ViewManager. init with allShares)
        // init SharesController (inside - add it to the ControllerManager)

        // init BrokerFrame
        // add AllCustomersView as Tab
        // add CustomerInfoView as Tab
        // add SharesView as Tab
        // make Visible BrokerFrame

        try {

            // Init properties
            PropertiesManager propertiesManager = PropertiesManager.getInstance();
            propertiesManager.initProperties();

            // Init Dispatcher, ViewManager and ControllerManager
            Dispatcher dispatcher = Dispatcher.getInstance();
            ViewManager viewManager = ViewManager.getInstance();
            ControllerManager controllerManager = ControllerManager.getInstance();
            RegistryManager registryManager = RegistryManager.getInstance();

            // Init Real Model
            DataModel dataModel = new DataModel();
            dispatcher.setModel(dataModel);


            // Init AllCustomersView
            AllCustomersViewModel allCustomersViewModel;
            if (!dispatcher.hasAllCustomersInModel()) {
               try {
                    Command customersCommand = registryManager.getCommand(RMIUtils.RMI_GET_ALL_CUSTOMERS);
                    customersCommand.execute();
                    Dispatcher.getInstance().setCustomerTOs((CustomersListTO) customersCommand.getResult());
                } catch (RemoteException e) {
                    logger.log(Level.SEVERE, Strings.REMOTE_EXCEPTION);
                } catch (KadetException e) {
                    logger.log(Level.SEVERE, e.getMessage());
                }
            }
            allCustomersViewModel = (dispatcher.hasAllCustomersInModel()) ? dispatcher.getAllCustomersViewModel() : dispatcher.getDefaultAllCustomersViewModel();

            AllCustomersView allCustomersView = (AllCustomersView) viewManager.newView(AllCustomersView.class.getName());
            allCustomersView.setViewModel(allCustomersViewModel);
            viewManager.subscribe(allCustomersView, allCustomersViewModel);
            viewManager.subscribeOnNobodyElse(allCustomersView);

            AllCustomersController allCustomersController = (AllCustomersController) controllerManager.newController(AllCustomersController.class.getName());
            allCustomersController.setViewModel(allCustomersViewModel);


            // Init CustomerInfoView
            CustomerInfoViewModel customerInfoViewModel = new CustomerInfoViewModel();
            customerInfoViewModel.setCustomerTO(dispatcher.getDefaultCustomerTO());
            CustomerInfoView customerInfoView = (CustomerInfoView) viewManager.newView(CustomerInfoView.class.getName());
            customerInfoView.setViewModel(customerInfoViewModel);
            viewManager.subscribe(customerInfoView, customerInfoViewModel);

            // Init StocksView
            StocksViewModel stocksViewModel;
            if (!dispatcher.hasAllStocksInModel()) {
                try {
                    Command stocksCommand = registryManager.getCommand(RMIUtils.RMI_GET_ALL_STOCKS);
                    stocksCommand.execute();
                    Dispatcher.getInstance().setStockTOs((StocksListTO) stocksCommand.getResult());
                } catch (RemoteException e) {
                    logger.log(Level.SEVERE, Strings.REMOTE_EXCEPTION);
                } catch (KadetException e) {
                    logger.log(Level.SEVERE, e.getMessage());
                }
            }
            stocksViewModel = (dispatcher.hasAllStocksInModel()) ? dispatcher.getStocksViewModel() : dispatcher.getDefaultStocksViewModel();

            StocksView stocksView = (StocksView) viewManager.newView(StocksView.class.getName());
            stocksView.setViewModel(stocksViewModel);
            viewManager.subscribe(stocksView, stocksViewModel);
            viewManager.subscribeOnNobodyElse(stocksView);

            StocksController stocksController = (StocksController) controllerManager.newController(StocksController.class.getName());
            stocksController.setViewModel(stocksViewModel);


            // Init Broker Frame
            BrokerFrame brokerFrame = new BrokerFrame();

            // Add all to frame
            brokerFrame.addTab(Strings.ALL_CUSTOMERS_TAB, allCustomersView);
            brokerFrame.addTab(Strings.CUSTOMER_INFO_TAB, customerInfoView);
            brokerFrame.addTab(Strings.STOCKS_TAB, stocksView);

            brokerFrame.setVisible(true);

        } catch (KadetException e) {
            logger.log(Level.SEVERE, Strings.INITIALIZE_EXCEPTION);
        }

    }

    private void fillDataModel(DataModel dataModel) {

        CustomerTO customer1 = new CustomerTO();
        customer1.setId("123");
        customer1.setName("Kadet1");
        customer1.setAddress("Address1");
        CustomerTO customer2 = new CustomerTO();
        customer2.setId("223");
        customer2.setName("Kadet2");
        customer2.setAddress("Address2");
        CustomerTO customer3 = new CustomerTO();
        customer3.setId("323");
        customer3.setName("Kadet3");
        customer3.setAddress("Address3");
        CustomerTO customer4 = new CustomerTO();
        customer4.setId("423");
        customer4.setName("Kadet4");
        customer4.setAddress("Address4");

        dataModel.addCustomerTO(customer1);
        dataModel.addCustomerTO(customer2);
        dataModel.addCustomerTO(customer3);
        dataModel.addCustomerTO(customer4);

    }


}


