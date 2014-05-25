package com.kadet.kadetBroker.controller;

import com.kadet.kadetBroker.command.Command;
import com.kadet.kadetBroker.command.UpdateCustomerCommand;
import com.kadet.kadetBroker.fwk.CommandManager;
import com.kadet.kadetBroker.fwk.Dispatcher;
import com.kadet.kadetBroker.util.Strings;
import com.kadet.kadetBroker.viewModel.UpdateCustomerViewModel;
import com.kadet.kadetBroker.viewModel.ViewModel;

/**
 * Date: 19.05.14
 * Time: 13:43
 *
 * @author SarokaA
 */
public class UpdateCustomerController implements Controller {

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

        CommandManager commandManager = CommandManager.getInstance();
        UpdateCustomerCommand command = (UpdateCustomerCommand) commandManager.newCommand(Strings.UPDATE_CUSTOMER_COMMAND);
        command.setToServer(viewModel.getNewCustomerTO());
        commandManager.executeCommand(command);

    }


}
