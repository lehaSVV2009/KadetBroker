package com.kadet.kadetBroker;

import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.fwk.PropertiesManager;
import com.kadet.kadetBroker.util.Paths;

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

            PropertiesManager propertiesManager = PropertiesManager.getInstance();

            propertiesManager.initViewsProperties(Paths.VIEWS_PROPERTIES_PATH);
            propertiesManager.initControllersProperties(Paths.CONTROLLERS_PROPERTIES_PATH);
            propertiesManager.initViewControllerMappingProperties(Paths.VIEW_CONTROLLER_MAPPING_PROPERTIES_PATH);



        } catch (KadetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }



}
