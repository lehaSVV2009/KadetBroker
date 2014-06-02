package com.kadet.kadetBroker.actions;

import com.kadet.kadetBroker.controller.Controller;
import com.kadet.kadetBroker.fwk.ControllerManager;
import com.kadet.kadetBroker.fwk.ViewManager;
import com.kadet.kadetBroker.util.Strings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Date: 16.05.14
 * Time: 5:22
 *
 * @author Кадет
 */
public class AllCustomersButtonsAction implements ActionListener {

    private static Logger logger = Logger.getLogger(AllCustomersButtonsAction.class.getName());

    @Override
    public void actionPerformed (ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if (Strings.ADD_CUSTOMER_BUTTON.equals(actionCommand)) {

            logger.log(Level.INFO, Strings.ADD_CUSTOMER_WAS_PRESSED);
            showCreateCustomerDialog();

        } else if (Strings.REMOVE_CUSTOMER_BUTTON.equals(actionCommand)) {

            logger.log(Level.INFO, Strings.REMOVE_CUSTOMER_WAS_PRESSED);
            removeCustomer();

        } else if (Strings.UPDATE_CUSTOMER_BUTTON.equals(actionCommand)) {

            logger.log(Level.INFO, Strings.UPDATE_CUSTOMER_WAS_PRESSED);
            showUpdateCustomerDialog();

        } else if (Strings.REFRESH_CUSTOMERS_BUTTON.equals(actionCommand)) {

            logger.log(Level.INFO, Strings.REFRESH_CUSTOMERS_WAS_PRESSED);
            refreshCustomers();

        }
    }

    private void showCreateCustomerDialog () {

        String methodName = "showCreateCustomerDialog";
        try {
            List<Controller> controllers = ControllerManager.getInstance().getControllersByView(ViewManager.getInstance().getActiveView());
            for (Controller controller : controllers) {
                Method showCreateCustomerDialog = controller.getClass().getMethod(methodName);
                showCreateCustomerDialog.setAccessible(true);
                showCreateCustomerDialog.invoke(controller);
            }
        } catch (NoSuchMethodException e) {
            logger.log(Level.SEVERE, Strings.WRONG_NAME_OF_CONTROLLER_METHOD + methodName);
        } catch (InvocationTargetException e) {
            logger.log(Level.SEVERE, Strings.CAN_NOT_INVOKE_CONTROLLER);
        } catch (IllegalAccessException e) {
            logger.log(Level.SEVERE, Strings.CAN_NOT_INVOKE_CONTROLLER);
        }

    }

    private void showUpdateCustomerDialog () {

        String methodName = "showUpdateCustomerDialog";
        try {
            List<Controller> controllers = ControllerManager.getInstance().getControllersByView(ViewManager.getInstance().getActiveView());
            for (Controller controller : controllers) {
                Method showCreateCustomerDialog = controller.getClass().getMethod(methodName);
                showCreateCustomerDialog.setAccessible(true);
                showCreateCustomerDialog.invoke(controller);
            }
        }  catch (NoSuchMethodException e) {
            logger.log(Level.SEVERE, Strings.WRONG_NAME_OF_CONTROLLER_METHOD + methodName);
        } catch (InvocationTargetException e) {
            logger.log(Level.SEVERE, Strings.CAN_NOT_INVOKE_CONTROLLER);
        } catch (IllegalAccessException e) {
            logger.log(Level.SEVERE, Strings.CAN_NOT_INVOKE_CONTROLLER);
        }
    }

    private void removeCustomer () {

        String methodName = "removeCustomer";
        try {
            List<Controller> controllers = ControllerManager.getInstance().getControllersByView(ViewManager.getInstance().getActiveView());
            for (Controller controller : controllers) {
                Method showCreateCustomerDialog = controller.getClass().getMethod(methodName);
                showCreateCustomerDialog.setAccessible(true);
                showCreateCustomerDialog.invoke(controller);
            }
        } catch (NoSuchMethodException e) {
            logger.log(Level.SEVERE, Strings.WRONG_NAME_OF_CONTROLLER_METHOD + methodName);
        } catch (InvocationTargetException e) {
            logger.log(Level.SEVERE, Strings.CAN_NOT_INVOKE_CONTROLLER);
        } catch (IllegalAccessException e) {
            logger.log(Level.SEVERE, Strings.CAN_NOT_INVOKE_CONTROLLER);
        }

    }


    private void refreshCustomers () {

        String methodName = "refreshCustomers";
        try {
            List<Controller> controllers = ControllerManager.getInstance().getControllersByView(ViewManager.getInstance().getActiveView());
            for (Controller controller : controllers) {
                Method showCreateCustomerDialog = controller.getClass().getMethod(methodName);
                showCreateCustomerDialog.setAccessible(true);
                showCreateCustomerDialog.invoke(controller);
            }
        } catch (NoSuchMethodException e) {
            logger.log(Level.SEVERE, Strings.WRONG_NAME_OF_CONTROLLER_METHOD + methodName);
        } catch (InvocationTargetException e) {
            logger.log(Level.SEVERE, Strings.CAN_NOT_INVOKE_CONTROLLER);
        } catch (IllegalAccessException e) {
            logger.log(Level.SEVERE, Strings.CAN_NOT_INVOKE_CONTROLLER);
        }
    }



}