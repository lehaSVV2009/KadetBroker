package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.view.LoggerView;

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

}
