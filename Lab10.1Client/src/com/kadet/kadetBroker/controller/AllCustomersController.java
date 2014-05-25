package com.kadet.kadetBroker.controller;

import com.kadet.kadetBroker.command.RemoveCustomerCommand;
import com.kadet.kadetBroker.dialog.AddCustomerDialog;
import com.kadet.kadetBroker.dialog.UpdateCustomerDialog;
import com.kadet.kadetBroker.fwk.*;
import com.kadet.kadetBroker.to.CustomerTO;
import com.kadet.kadetBroker.util.Strings;
import com.kadet.kadetBroker.view.LoggerPanel;
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

    private AllCustomersViewModel viewModel;

    public AllCustomersController () {
    }

    public void showCreateCustomerDialog () {

        System.out.println("Show Create Customer Dialog");
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
        if (currentCustomer.getId() == null || "".equals(currentCustomer.getId())) {
            log(Strings.CHOOSE_CUSTOMER);
        } else {
            System.out.println("Show Update Customer Dialog");
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
        if (currentCustomer.getId() == null || "".equals(currentCustomer.getId())) {
            log(Strings.CHOOSE_CUSTOMER);
        } else {
            RemoveCustomerCommand removeCustomerCommand = (RemoveCustomerCommand) CommandManager.getInstance().newCommand(Strings.REMOVE_CUSTOMER_COMMAND);
            removeCustomerCommand.setToServer(viewModel.getCurrentCustomerTO());

            CommandManager.getInstance().executeCommand(removeCustomerCommand);

        }

    }



    private void log (String text) {
        LoggerPanel loggerPanel = ViewManager.getInstance().getActiveLoggerPanel();
        loggerPanel.addText(text);
        loggerPanel.refresh();
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
