package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.entity.Customer;
import com.kadet.kadetBroker.view.*;

import java.util.List;

/**
 * Date: 16.05.14
 * Time: 5:11
 *
 * @author Кадет
 */
public class ViewFactory {

    private final static ViewFactory instance = new ViewFactory();

    public static ViewFactory getInstance () {
        return instance;
    }

    private ViewFactory() {}

    public static LoggerView createLoggerView () {
        return new LoggerView();
    }


    public static AbstractView createView (ViewType viewType, Object parameter) {
        switch (viewType) {
            case ALL_CUSTOMERS_VIEW : {
                return new AllCustomersView((List<Customer>)parameter);
            }
            case CUSTOMER_INFO_VIEW: {
                return new CustomerInfoView();
            }
            case STOCKS_VIEW : {
                return new StocksView();
            }
            default : {
                return new EmptyView();
            }
        }
    }


}
