package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.controller.Controller;
import com.kadet.kadetBroker.controller.ControllerType;
import sun.management.resources.agent_pt_BR;

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

    public Controller newController (ControllerType controllerType, Object parameter) {
        Controller controller = ControllerFactory.createController(controllerType, parameter);
        controllers.add(controller);
        return controller;
    }

    public void removeController (Controller controller) {
        controllers.remove(controller);
    }
    
}
