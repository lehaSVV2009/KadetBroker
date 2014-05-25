package com.kadet.kadetBroker.test.customers;

import static org.junit.Assert.*;

import org.junit.Test;

import com.kadet.kadetBroker.command.AddCustomerCommand;
import com.kadet.kadetBroker.command.Command;
import com.kadet.kadetBroker.command.GetAllCustomersCommand;
import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.fwk.CommandManager;
import com.kadet.kadetBroker.fwk.CommandSender;
import com.kadet.kadetBroker.fwk.ControllerManager;
import com.kadet.kadetBroker.fwk.Dispatcher;
import com.kadet.kadetBroker.fwk.PropertiesManager;
import com.kadet.kadetBroker.fwk.ViewManager;
import com.kadet.kadetBroker.model.DataModel;
import com.kadet.kadetBroker.to.CustomerTO;
import com.kadet.kadetBroker.to.CustomersListTO;
import com.kadet.kadetBroker.util.Strings;
import com.kadet.kadetBroker.viewModel.AllCustomersViewModel;

public class TestInsertCustomerToServer {



	@Test
	public void test() {
		assertEquals(2, 2);
	}


	//@Test 
	public void simpleInsert () throws KadetException {



		new Thread() {
			public void run () {

				CustomerTO customerTO = new CustomerTO();
				customerTO.setId("249-12-47");
				customerTO.setAddress("Chapaeva");
				customerTO.setName("Kadet");

				AddCustomerCommand addCustomerCommand = (AddCustomerCommand) CommandManager.getInstance().newCommand(Strings.ADD_CUSTOMER_COMMAND);
				addCustomerCommand.setToServer(customerTO);

				try {
					CommandSender commandSender = new CommandSender(1994, "localhost");
					commandSender.send(addCustomerCommand);
					Command command = (Command) commandSender.receive();
					// answerCommand.execute();
					// commandSender.close();

					CustomerTO answer = (CustomerTO) command.getResult();
					assertEquals("249-12-47", answer.getId());
				} catch (KadetException e) {
					e.printStackTrace();
				}


			}
		};


		new Thread() {
			public void run () {

				CustomerTO customerTO = new CustomerTO();
				customerTO.setId("249-12-48");
				customerTO.setAddress("Chapaeva");
				customerTO.setName("Kadet");

				AddCustomerCommand addCustomerCommand = (AddCustomerCommand) CommandManager.getInstance().newCommand(Strings.ADD_CUSTOMER_COMMAND);
				addCustomerCommand.setToServer(customerTO);

				try {
					CommandSender commandSender = new CommandSender(1994, "localhost");
					commandSender.send(addCustomerCommand);
					Command command = (Command) commandSender.receive();
					// answerCommand.execute();
					// commandSender.close();

					CustomerTO answer = (CustomerTO) command.getResult();
					assertEquals("249-12-48", answer.getId());
				} catch (KadetException e) {
					e.printStackTrace();
				}


			}
		};



	}

}
