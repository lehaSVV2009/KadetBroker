package com.kadet.kadetBroker.test;

import java.rmi.RemoteException;

import com.kadet.kadetBroker.command.*;
import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.fwk.CommandManager;
import com.kadet.kadetBroker.fwk.CommandSender;
import com.kadet.kadetBroker.fwk.PropertiesManager;
import com.kadet.kadetBroker.to.CustomerTO;
import com.kadet.kadetBroker.util.Strings;

/**
 * Date: 22.05.14
 * Time: 8:40
 *
 * @author SarokaA
 */
public class ServerTest {

    public static void main (String[] args) {
        /*try {
            PropertiesManager.getInstance().initProperties();
        } catch (KadetException e) {
            e.printStackTrace();
        }

        CustomerTO customerTO = new CustomerTO();
        customerTO.setId("15-12-43");
        customerTO.setAddress("Chapaeva");
        customerTO.setName("Kadet");

        String commandClassName = PropertiesManager.getInstance().getCommandClassName(Strings.ADD_CUSTOMER_COMMAND);
        AddCustomerCommand addCustomerCommand = (AddCustomerCommand) CommandManager.getInstance().newCommand(commandClassName);
        addCustomerCommand.setToServer(customerTO);

        try {
            CommandSender commandSender = new CommandSender(1994, "localhost");
            commandSender.send(addCustomerCommand);
            Command answerCommand = (Command) commandSender.receive();
            answerCommand.execute();
            commandSender.close();
        } catch (KadetException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        customerTO.setAddress("Napoleona");
        customerTO.setName("Kadet2");

        commandClassName = PropertiesManager.getInstance().getCommandClassName(Strings.UPDATE_CUSTOMER_COMMAND);
        UpdateCustomerCommand updateCustomerCommand = (UpdateCustomerCommand) CommandManager.getInstance().newCommand(commandClassName);
        updateCustomerCommand.setToServer(customerTO);

        try {
            CommandSender commandSender = new CommandSender(1994, "localhost");
            commandSender.send(updateCustomerCommand);
            Command answerCommand = (Command) commandSender.receive();
            answerCommand.execute();
            commandSender.close();
        } catch (KadetException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        commandClassName = PropertiesManager.getInstance().getCommandClassName(Strings.REMOVE_CUSTOMER_COMMAND);
        RemoveCustomerCommand removeCustomerCommand = (RemoveCustomerCommand) CommandManager.getInstance().newCommand(commandClassName);
        removeCustomerCommand.setToServer(customerTO);

        try {
            CommandSender commandSender = new CommandSender(1994, "localhost");
            commandSender.send(removeCustomerCommand);
            Command answerCommand = (Command) commandSender.receive();
            answerCommand.execute();
            commandSender.close();
        } catch (KadetException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}





        commandClassName = PropertiesManager.getInstance().getCommandClassName(Strings.GET_ALL_CUSTOMERS_COMMAND);
        GetAllCustomersCommand getAllCustomersCommand = (GetAllCustomersCommand) CommandManager.getInstance().newCommand(commandClassName);
        getAllCustomersCommand.setToServer(customerTO);

        try {
            CommandSender commandSender = new CommandSender(1994, "localhost");
            commandSender.send(getAllCustomersCommand);
            Command answerCommand = (Command) commandSender.receive();
            answerCommand.execute();
            commandSender.close();
        } catch (KadetException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    }

}
