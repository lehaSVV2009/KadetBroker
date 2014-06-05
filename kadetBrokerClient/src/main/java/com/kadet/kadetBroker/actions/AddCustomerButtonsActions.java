package com.kadet.kadetBroker.actions;

import com.kadet.kadetBroker.controller.Controller;
import com.kadet.kadetBroker.dialog.AddCustomerDialog;
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
 * Date: 18.05.14
 * Time: 8:15
 *
 * @author SarokaA
 */
public class AddCustomerButtonsActions implements ActionListener {

    private static Logger logger = Logger.getLogger(AddCustomerButtonsActions.class.getName());

    @Override
    public void actionPerformed (ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if (Strings.ADD_CUSTOMER_BUTTON.equals(actionCommand)) {

            doOk();
            logger.log(Level.INFO, Strings.ADD_CUSTOMER_WAS_PRESSED);

        } else if (Strings.RESET_CUSTOMER_BUTTON.equals(actionCommand)) {

            doReset();

        }
    }

    private void doOk () {
        String methodName = "addCustomer";
        AddCustomerDialog view = (AddCustomerDialog) ViewManager.getInstance().getActiveView();

        try {
            List<Controller> controllers = ControllerManager.getInstance().getControllersByView(view);
            for (Controller controller : controllers) {
                Method showCreateCustomerDialog = controller.getClass().getMethod(methodName);
                showCreateCustomerDialog.setAccessible(true);
                showCreateCustomerDialog.invoke(controller);
            }
            view.dispose();
        } catch (NoSuchMethodException e) {
            logger.log(Level.SEVERE, Strings.WRONG_NAME_OF_CONTROLLER_METHOD + methodName);
        } catch (InvocationTargetException e) {
            logger.log(Level.SEVERE, Strings.CAN_NOT_INVOKE_CONTROLLER);
        } catch (IllegalAccessException e) {
            logger.log(Level.SEVERE, Strings.CAN_NOT_INVOKE_CONTROLLER);
        }
    }

    private void doReset () {

    }


}
