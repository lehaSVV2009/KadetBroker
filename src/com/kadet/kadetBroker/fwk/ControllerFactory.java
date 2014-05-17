package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.controller.*;
import com.kadet.kadetBroker.entity.Customer;

import java.util.List;
import java.util.Objects;

/**
 * Date: 16.05.14
 * Time: 8:31
 *
 * @author SarokaA
 */
public class ControllerFactory {

    private final static ControllerFactory instance = new ControllerFactory();

    public static ControllerFactory getInstance () {
        return instance;
    }

    private ControllerFactory() {}

    public static Controller createController (ControllerType controllerType, Object parameter) {
        switch (controllerType) {
            case ALL_CUSTOMERS_CONTROLLER : {
                return new AllCustomersController((List<Customer>)parameter);
            }
            case STOCKS_CONTROLLER : {
                return new StocksController();
            }
            default : {
                return new EmptyController();
            }
        }
    }


}
