package com.kadet.kadetBroker.actions;

import com.kadet.kadetBroker.controller.Controller;
import com.kadet.kadetBroker.dialog.UpdateCustomerDialog;
import com.kadet.kadetBroker.fwk.ControllerManager;
import com.kadet.kadetBroker.fwk.ViewManager;
import com.kadet.kadetBroker.util.Strings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Date: 19.05.14
 * Time: 16:04
 *
 * @author SarokaA
 */
public class UpdateCustomerButtonsActions implements ActionListener{

    @Override
    public void actionPerformed (ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if (Strings.UPDATE_CUSTOMER_BUTTON.equals(actionCommand)) {
            doOk();
        } else if (Strings.RESET_CUSTOMER_BUTTON.equals(actionCommand)) {
            doReset();
        }
    }

    private void doOk () {
        UpdateCustomerDialog view = (UpdateCustomerDialog) ViewManager.getInstance().getActiveView();
        // TODO: validate view
        try {
            List<Controller> controllers = ControllerManager.getInstance().getControllersByView(view);
            for (Controller controller : controllers) {
                Method showCreateCustomerDialog = controller.getClass().getMethod("updateCustomer");
                showCreateCustomerDialog.setAccessible(true);
                showCreateCustomerDialog.invoke(controller);
            }
            view.dispose();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void doReset () {

    }

}
