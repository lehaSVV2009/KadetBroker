package com.kadet.kadetBroker.actions;

import com.kadet.kadetBroker.controller.Controller;
import com.kadet.kadetBroker.fwk.ControllerManager;
import com.kadet.kadetBroker.fwk.PropertiesManager;
import com.kadet.kadetBroker.fwk.ViewManager;
import com.kadet.kadetBroker.util.Strings;
import com.kadet.kadetBroker.view.AllCustomersView;
import com.kadet.kadetBroker.view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Date: 16.05.14
 * Time: 5:22
 *
 * @author Кадет
 */
public class AllCustomersButtonAction implements ActionListener {

    @Override
    public void actionPerformed (ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if (Strings.ADD_CUSTOMER_BUTTON.equals(actionCommand)) {
            System.out.println(actionCommand);
            showCreateCustomerDialog();
        } else if (Strings.REMOVE_CUSTOMER_BUTTON.equals(actionCommand)) {
            System.out.println(actionCommand);

        } else if (Strings.UPDATE_CUSTOMER_BUTTON.equals(actionCommand)) {
            System.out.println(actionCommand);

        }
    }

    private void showCreateCustomerDialog () {

        AllCustomersView view = (AllCustomersView)ViewManager.getInstance().getActiveView();
        String controllerClassName = PropertiesManager.getInstance().getControllerClassNameByViewClassName(view.getClass().getName());
        try {
            List<Controller> controllers = ControllerManager.getInstance().getControllersByClassName(controllerClassName);
            for (Controller controller : controllers) {
                Method getCurrentCustomer = controller.getClass().getMethod("getCurrentCustomer");
                getCurrentCustomer.setAccessible(true);
                Method getCustomers = controller.getClass().getMethod("getCustomers");
                getCustomers.setAccessible(true);
                if (view.getCurrentCustomer().equals(getCurrentCustomer.invoke(controller))
                        && view.getCustomers().equals(getCustomers.invoke(controller))) {
                    Method showCreateCustomerDialog = controller.getClass().getMethod("showCreateCustomerDialog");
                    showCreateCustomerDialog.setAccessible(true);
                    showCreateCustomerDialog.invoke(controller);
                }
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
