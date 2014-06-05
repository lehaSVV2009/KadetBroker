package com.kadet.kadetBroker.controller;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.kadet.kadetBroker.command.Command;
import com.kadet.kadetBroker.dialog.AddCustomerDialog;
import com.kadet.kadetBroker.dialog.UpdateCustomerDialog;
import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.fwk.*;
import com.kadet.kadetBroker.to.CustomerTO;
import com.kadet.kadetBroker.rmi.RMIUtils;
import com.kadet.kadetBroker.to.CustomersListTO;
import com.kadet.kadetBroker.util.Strings;
import com.kadet.kadetBroker.viewModel.AddCustomerViewModel;
import com.kadet.kadetBroker.viewModel.AllCustomersViewModel;
import com.kadet.kadetBroker.viewModel.UpdateCustomerViewModel;
import com.kadet.kadetBroker.viewModel.ViewModel;

/**
 * Date: 16.05.14
 * Time: 8:15
 *
 * @author SarokaA
 */
public class AllCustomersController implements Controller {

    private static Logger logger = Logger.getLogger(AllCustomersController.class.getName());

    private AllCustomersViewModel viewModel;

    public AllCustomersController () {
    }

    public void showCreateCustomerDialog () {

        AddCustomerViewModel addCustomerViewModel = Dispatcher.getInstance().getDefaultAddCustomerViewModel();
        AddCustomerDialog addCustomerDialog = (AddCustomerDialog) DialogFactory.createDialog(AddCustomerDialog.class.getName());
        addCustomerDialog.setViewModel(addCustomerViewModel);

        AddCustomerController addCustomerController = (AddCustomerController) ControllerManager.getInstance().newController(AddCustomerController.class.getName());
        addCustomerController.setViewModel(addCustomerViewModel);

        ViewManager.getInstance().setActiveView(addCustomerDialog);
        addCustomerDialog.setVisible(true);

    }

    public void showUpdateCustomerDialog () {

        CustomerTO currentCustomer = viewModel.getCurrentCustomerTO();

        if (!validateUpdatedCustomer(currentCustomer)) {

            log(Strings.CHOOSE_CUSTOMER);

        } else {
            CustomerTO newCustomer = Dispatcher.getInstance().getDefaultCustomerTO();
            CustomerTO oldCustomer = currentCustomer;
            UpdateCustomerViewModel updateCustomerViewModel = new UpdateCustomerViewModel();
            updateCustomerViewModel.setNewCustomerTO(newCustomer);
            updateCustomerViewModel.setOldCustomerTO(oldCustomer);

            UpdateCustomerDialog updateCustomerDialog = (UpdateCustomerDialog) DialogFactory.createDialog(UpdateCustomerDialog.class.getName());
            updateCustomerDialog.setViewModel(updateCustomerViewModel);

            UpdateCustomerController updateCustomerController = (UpdateCustomerController) ControllerManager.getInstance().newController(UpdateCustomerController.class.getName());
            updateCustomerController.setViewModel(updateCustomerViewModel);

            ViewManager.getInstance().setActiveView(updateCustomerDialog);
            updateCustomerDialog.setVisible(true);
        }
    }

    public void removeCustomer () {

        CustomerTO currentCustomer = viewModel.getCurrentCustomerTO();

        if (!validateRemovedCustomer(currentCustomer)) {

            log(Strings.CHOOSE_CUSTOMER);
            return;

        }
        try {

            Command command = RegistryManager.getInstance().getCommand(RMIUtils.RMI_REMOVE_CUSTOMER);
            command.setTO(currentCustomer);
            command.execute();

            if (command.getException() != null) {

                ViewManager.getInstance().setMessageToLogger(command.getException().getMessage());

            } else {

                CustomerTO customerTO = (CustomerTO) command.getResult();
                Dispatcher.getInstance().removeCustomerTO(customerTO);

            }

        } catch (KadetException e) {
            ViewManager.getInstance().setMessageToLogger(e.getMessage());
        } catch (RemoteException e) {
            ViewManager.getInstance().setMessageToLogger(Strings.CAN_NOT_GET_DATA_FROM_SERVER);
        }

    }

    private boolean validateUpdatedCustomer (CustomerTO customerTO) {
        return  customerTO.getId() != null
                && customerTO.getName() != null
                && customerTO.getAddress() != null
                && (!"".equals(customerTO.getId().trim()));
    }

    private boolean validateRemovedCustomer (CustomerTO customerTO) {
        return (customerTO.getId() != null) && (!"".equals(customerTO.getId()));
    }

    public void refreshCustomers () {

        try {

            Command command = RegistryManager.getInstance().getCommand(RMIUtils.RMI_GET_ALL_CUSTOMERS);
            command.execute();

            if (command.getException() != null) {

                ViewManager.getInstance().setMessageToLogger(command.getException().getMessage());

            } else {

                CustomersListTO customersListTO = (CustomersListTO) command.getResult();
                Dispatcher.getInstance().setCustomerTOs(customersListTO);

            }

        } catch (KadetException e) {
            ViewManager.getInstance().setMessageToLogger(e.getMessage());
        } catch (RemoteException e) {
            ViewManager.getInstance().setMessageToLogger(Strings.CAN_NOT_GET_DATA_FROM_SERVER);
        }

    }



    private void log (String text) {
        logger.log(Level.SEVERE, text);
        ViewManager.getInstance().setMessageToLogger(text);
    }

    @Override
    public void setViewModel (ViewModel viewModel) {
        this.viewModel = (AllCustomersViewModel) viewModel;
    }

    @Override
    public ViewModel getViewModel () {
        return viewModel;
    }
}
