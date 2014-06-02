package com.kadet.kadetBroker.controller;

import com.kadet.kadetBroker.command.Command;
import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.fwk.Dispatcher;
import com.kadet.kadetBroker.fwk.RegistryManager;
import com.kadet.kadetBroker.fwk.ViewManager;
import com.kadet.kadetBroker.rmi.RMIUtils;
import com.kadet.kadetBroker.to.CustomerTO;
import com.kadet.kadetBroker.util.Strings;
import com.kadet.kadetBroker.viewModel.UpdateCustomerViewModel;
import com.kadet.kadetBroker.viewModel.ViewModel;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Date: 19.05.14
 * Time: 13:43
 *
 * @author SarokaA
 */
public class UpdateCustomerController implements Controller {

    private static Logger logger = Logger.getLogger(UpdateCustomerController.class.getName());

    private UpdateCustomerViewModel viewModel;

    @Override
    public void setViewModel (ViewModel viewModel) {
        this.viewModel = (UpdateCustomerViewModel) viewModel;
    }

    @Override
    public ViewModel getViewModel () {
        return viewModel;
    }


    public void updateCustomer () {

        CustomerTO newCustomerTO = viewModel.getNewCustomerTO();
        if (!validateUpdatedCustomer(newCustomerTO)) {

            logger.log(Level.SEVERE, Strings.INCORRECT_UPDATING);
            ViewManager.getInstance().setMessageToLogger(Strings.INCORRECT_UPDATING);
            return;
        }
        try {

            Command command = RegistryManager.getInstance().getCommand(RMIUtils.RMI_UPDATE_CUSTOMER);
            command.setTO(viewModel.getNewCustomerTO());
            command.execute();

            if (command.getException() != null) {

                ViewManager.getInstance().setMessageToLogger(command.getException().getMessage());

            } else {

                Dispatcher.getInstance().updateCustomerTO((CustomerTO) command.getResult());

            }
        } catch (KadetException e) {
            ViewManager.getInstance().setMessageToLogger(e.getMessage());
        } catch (RemoteException e) {
            ViewManager.getInstance().setMessageToLogger(Strings.CAN_NOT_GET_DATA_FROM_SERVER);
        }
    }


    private boolean validateUpdatedCustomer(CustomerTO newCustomerTO) {
        return  newCustomerTO.getId() != null
                && newCustomerTO.getName() != null
                && newCustomerTO.getAddress() != null
                && (!"".equals(newCustomerTO.getId().trim()))
                && (!"".equals(newCustomerTO.getName().trim()))
                && (!"".equals(newCustomerTO.getAddress().trim()));
    }


}
