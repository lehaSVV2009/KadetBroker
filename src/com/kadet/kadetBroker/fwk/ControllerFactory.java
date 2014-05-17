package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.controller.Controller;

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

    public static Controller createController (String className) {
        try {
            return (Controller) Class.forName(className).newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to instantiate" + className);
        }
    }


}
