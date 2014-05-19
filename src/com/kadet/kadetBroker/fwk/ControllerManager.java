package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.controller.Controller;
import com.kadet.kadetBroker.view.AllCustomersView;
import com.kadet.kadetBroker.view.View;

import java.lang.reflect.Method;
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

    public List<Controller> getControllersByClassName (String className) {
        List<Controller> controllersWithSuchClassName = new ArrayList<Controller>();
        for (Controller controller : controllers) {
            if (className.equals(controller.getClass().getName())) {
                controllersWithSuchClassName.add(controller);
            }
        }
        return controllersWithSuchClassName;
    }

    public List<Controller> getControllersByView (View view) {
        String controllerClassName = PropertiesManager.getInstance().getControllerClassNameByViewClassName(view.getClass().getName());
        List<Controller> controllers = ControllerManager.getInstance().getControllersByClassName(controllerClassName);

        for (Controller controller : controllers) {
            if (!view.getModel().equals(controller.getModel())) {
                controllers.remove(controller);
            }
        }
        return controllers;
    }

    
}
