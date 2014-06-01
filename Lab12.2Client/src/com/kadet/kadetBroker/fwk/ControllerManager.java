package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.controller.Controller;
import com.kadet.kadetBroker.view.View;

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

        for (int controllerIndex = 0; controllerIndex < controllers.size(); ++controllerIndex) {
            Controller controller = controllers.get(controllerIndex);
            if (!view.getViewModel().equals(controller.getViewModel())) {
                controllers.remove(controller);
                --controllerIndex;
            }
        }
        return controllers;
    }

    public void removeControllersByView (View view) {
        for (Controller controller : getControllersByView(view)) {
            removeController(controller);
        }
    }
    
}
