package com.kadet.kadetBroker.actions;

import com.kadet.kadetBroker.controller.Controller;
import com.kadet.kadetBroker.dto.AllCustomersDTO;
import com.kadet.kadetBroker.fwk.ControllerManager;
import com.kadet.kadetBroker.fwk.ViewManager;
import com.kadet.kadetBroker.util.Strings;
import com.kadet.kadetBroker.view.AllCustomersView;
import com.kadet.kadetBroker.view.LoggerPanel;

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
public class AllCustomersButtonsAction implements ActionListener {

    @Override
    public void actionPerformed (ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if (Strings.ADD_CUSTOMER_BUTTON.equals(actionCommand)) {
            //TODO: remove later
            System.out.println(actionCommand);
            showCreateCustomerDialog();
        } else if (Strings.REMOVE_CUSTOMER_BUTTON.equals(actionCommand)) {
            System.out.println(actionCommand);

        } else if (Strings.UPDATE_CUSTOMER_BUTTON.equals(actionCommand)) {
            System.out.println(actionCommand);
            showUpdateCustomerDialog();
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

        AllCustomersView view = (AllCustomersView)ViewManager.getInstance().getActiveView();
        if(((AllCustomersDTO)view.getModel()).getCurrentCustomer().getId() == null) {
            LoggerPanel loggerPanel = ViewManager.getInstance().getActiveLoggerPanel();
            loggerPanel.addViewText(view, Strings.CHOOSE_CUSTOMER);
            loggerPanel.refresh();
        } else {
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

    }

}
