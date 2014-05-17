package com.kadet.kadetBroker;

import com.kadet.kadetBroker.controller.Controller;
import com.kadet.kadetBroker.controller.ControllerType;
import com.kadet.kadetBroker.entity.Customer;
import com.kadet.kadetBroker.entity.Portfolio;
import com.kadet.kadetBroker.entity.Share;
import com.kadet.kadetBroker.entity.Stock;
import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.fwk.*;
import com.kadet.kadetBroker.model.DataModel;
import com.kadet.kadetBroker.util.Paths;
import com.kadet.kadetBroker.util.Strings;
import com.kadet.kadetBroker.view.AbstractView;
import com.kadet.kadetBroker.view.BrokerFrame;
import com.kadet.kadetBroker.view.ViewType;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 16.05.14
 * Time: 4:45
 *
 * @author Кадет
 */
public class AppBundle {


    // ? Current customer (where is it stored?)
    // ? How does view subscribe on definite actions in viewManager
    // ? How to add different models as parameters to the ViewFactory in method createView



    public AppBundle () {

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
            propertiesManager.initViewsProperties(Paths.VIEWS_PROPERTIES_PATH);
            propertiesManager.initControllersProperties(Paths.CONTROLLERS_PROPERTIES_PATH);
            propertiesManager.initViewControllerMappingProperties(Paths.VIEW_CONTROLLER_MAPPING_PROPERTIES_PATH);

            // Init Dispatcher, ViewManager and ControllerManager
            Dispatcher dispatcher = Dispatcher.getInstance();
            ViewManager viewManager = ViewManager.getInstance();
            ControllerManager controllerManager = ControllerManager.getInstance();

            // Init Real Model
            DataModel dataModel = new DataModel();
            fillDataModel(dataModel);
            dispatcher.setModel(dataModel);

            // Init AllCustomersView
            List<Customer> customers = dispatcher.getAllCustomers();
            AbstractView allCustomersView = viewManager.newView(ViewType.ALL_CUSTOMERS_VIEW, customers);
            controllerManager.newController(ControllerType.ALL_CUSTOMERS_CONTROLLER, customers);

            // Init CustomerInfoView
            AbstractView customerInfoView = viewManager.newView(ViewType.CUSTOMER_INFO_VIEW, null);

            // Init StocksView
            AbstractView stocksView = viewManager.newView(ViewType.STOCKS_VIEW, null);
            controllerManager.newController(ControllerType.STOCKS_CONTROLLER, null);

            // Init Broker Frame
            BrokerFrame brokerFrame = new BrokerFrame();

            // Add all to frame
            brokerFrame.addTab(Strings.ALL_CUSTOMERS_TAB, allCustomersView);
            brokerFrame.addTab(Strings.CUSTOMER_INFO_TAB, customerInfoView);
            brokerFrame.addTab(Strings.STOCKS_TAB, stocksView);

            brokerFrame.setVisible(true);

        } catch (KadetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }

    private void fillDataModel (DataModel dataModel) {

        Customer customer1 = new Customer("123", "Kadet1", "Address1");
        Customer customer2 = new Customer("124", "Kadet2", "Address2");
        Customer customer3 = new Customer("125", "Kadet3", "Address3");
        Customer customer4 = new Customer("126", "Kadet4", "Address4");

        Share share1 = new Share(new Stock("AB", 100000));
        Share share2 = new Share(new Stock("AC", 2134213));
        Share share3 = new Share(new Stock("AD", 324242));
        Share share4 = new Share(new Stock("AE", 34535));
        Share share5 = new Share(new Stock("AF", 10000));
        Share share6 = new Share(new Stock("AG", 100034));
        Share share7 = new Share(new Stock("AH", 657867));
        Share share8 = new Share(new Stock("Free1", 23423));
        Share share9 = new Share(new Stock("Free2", 456456));
        Share share10 = new Share(new Stock("Free3", 45646));
        Share share11 = new Share(new Stock("Free4", 567567657));

        List<Share> shares1 = new ArrayList<Share>();
        shares1.add(share1);
        shares1.add(share2);
        shares1.add(share3);
        shares1.add(share4);

        List<Share> shares3 = new ArrayList<Share>();
        shares3.add(share5);
        shares3.add(share6);
        shares3.add(share7);

        List<Share> freeShares = new ArrayList<Share>();
        freeShares.add(share8);
        freeShares.add(share9);
        freeShares.add(share10);
        freeShares.add(share11);

        dataModel.setFreeShares(freeShares);
        dataModel.addPortfolio(new Portfolio(customer1, shares1));
        dataModel.addPortfolio(new Portfolio(customer2));
        dataModel.addPortfolio(new Portfolio(customer3, shares3));
        dataModel.addPortfolio(new Portfolio(customer4));

    }



}
