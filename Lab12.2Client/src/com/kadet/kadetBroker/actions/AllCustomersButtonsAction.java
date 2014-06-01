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

        try {
            List<Controller> controllers = ControllerManager.getInstance().getControllersByView(ViewManager.getInstance().getActiveView());
            for (Controller controller : controllers) {
                Method showCreateCustomerDialog = controller.getClass().getMethod("showCreateCustomerDialog");
                showCreateCustomerDialog.setAccessible(true);
                showCreateCustomerDialog.invoke(controller);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    private void showUpdateCustomerDialog () {

        try {
            List<Controller> controllers = ControllerManager.getInstance().getControllersByView(ViewManager.getInstance().getActiveView());
            for (Controller controller : controllers) {
                Method showCreateCustomerDialog = controller.getClass().getMethod("showUpdateCustomerDialog");
                showCreateCustomerDialog.setAccessible(true);
                showCreateCustomerDialog.invoke(controller);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void removeCustomer () {

        try {
            List<Controller> controllers = ControllerManager.getInstance().getControllersByView(ViewManager.getInstance().getActiveView());
            for (Controller controller : controllers) {
                Method showCreateCustomerDialog = controller.getClass().getMethod("removeCustomer");
                showCreateCustomerDialog.setAccessible(true);
                showCreateCustomerDialog.invoke(controller);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }


    private void refreshCustomers () {

        try {
            List<Controller> controllers = ControllerManager.getInstance().getControllersByView(ViewManager.getInstance().getActiveView());
            for (Controller controller : controllers) {
                Method showCreateCustomerDialog = controller.getClass().getMethod("refreshCustomers");
                showCreateCustomerDialog.setAccessible(true);
                showCreateCustomerDialog.invoke(controller);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }



}