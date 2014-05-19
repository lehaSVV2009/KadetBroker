package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.view.*;

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

    public static LoggerPanel createLoggerView () {
        return new LoggerPanel();
    }


    public static View createView (String className) {
        try {
            return (View) Class.forName(className).newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to instantiate" + className);
        }
    }


}
