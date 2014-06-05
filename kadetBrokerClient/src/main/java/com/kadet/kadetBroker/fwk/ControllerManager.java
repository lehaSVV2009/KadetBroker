package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.controller.Controller;
import com.kadet.kadetBroker.util.Strings;
import com.kadet.kadetBroker.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Date: 16.05.14
 * Time: 5:15
 *
 * @author Кадет
 */
public class ControllerManager {

    private static Logger logger = Logger.getLogger(ControllerManager.class.getName());

    private final static ControllerManager instance = new ControllerManager();

    public static ControllerManager getInstance () {
        return instance;
    }

    private ControllerManager() {}

    private List<Controller> controllers = new ArrayList<Controller>();

    public Controller newController (String controllerClassName) {
        Controller controller = ControllerFactory.createController(controllerClassName);
        controllers.add(controller);
        logger.log(Level.INFO, Strings.NEW_CONTROLLER_WAS_CREATED + ":" + controller.getClass().getName());
        return controller;
    }

    public void removeController (Controller controller) {
        controllers.remove(controller);
        logger.log(Level.INFO, Strings.CONTROLLER_WAS_REMOVED + ":" + controller.getClass().getName());
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
        ViewManager.getInstance().setMessageToLogger("");
        return controllers;
    }

    public void removeControllersByView (View view) {
        for (Controller controller : getControllersByView(view)) {
            removeController(controller);
        }
    }
    
}
