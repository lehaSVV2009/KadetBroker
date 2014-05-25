package com.kadet.kadetBroker.controller;

import com.kadet.kadetBroker.command.AddCustomerCommand;
import com.kadet.kadetBroker.command.Command;
import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.fwk.CommandManager;
import com.kadet.kadetBroker.fwk.CommandSender;
import com.kadet.kadetBroker.fwk.PropertiesManager;
import com.kadet.kadetBroker.util.Strings;
import com.kadet.kadetBroker.viewModel.AddCustomerViewModel;
import com.kadet.kadetBroker.viewModel.ViewModel;

/**
 * Date: 18.05.14
 * Time: 6:55
 *
 * @author SarokaA
 */
public class AddCustomerController implements Controller {


    private AddCustomerViewModel viewModel;

    public void addCustomer () {

        AddCustomerCommand addCustomerCommand = (AddCustomerCommand) CommandManager.getInstance().newCommand(Strings.ADD_CUSTOMER_COMMAND);
        addCustomerCommand.setToServer(viewModel.getNewCustomerTO());

        CommandManager.getInstance().executeCommand(addCustomerCommand);

    }



    @Override
    public void setViewModel (ViewModel viewModel) {
        this.viewModel = (AddCustomerViewModel) viewModel;
    }

    @Override
    public ViewModel getViewModel () {
        return viewModel;
    }
}
