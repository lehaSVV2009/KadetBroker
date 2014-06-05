package com.kadet.kadetBroker;

import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.to.CustomerTO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
/*
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
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

*/
			}
		};


		new Thread() {
			public void run () {

				CustomerTO customerTO = new CustomerTO();
				customerTO.setId("249-12-48");
				customerTO.setAddress("Chapaeva");
				customerTO.setName("Kadet");
/*
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
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

*/
			}
		};



	}

}
