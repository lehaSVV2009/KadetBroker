package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.controller.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 16.05.14
 * Time: 5:15
 *
 * @author Кадет
 */
public class ControllerManager {

    private final static ControllerManager instance = new ControllerManager();

    public static ControllerManager getInstance () {
        return instance;
    }

    private ControllerManager() {}

    private List<Controller> controllers = new ArrayList<Controller>();

    public Controller newController (String controllerClassName) {
        Controller controller = ControllerFactory.createController(controllerClassName);
        controllers.add(controller);
        return controller;
    }

    public void removeController (Controller controller) {
        controllers.remove(controller);
    }
    
}
