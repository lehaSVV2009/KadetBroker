package com.kadet.kadetBroker.test.customers;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import com.kadet.kadetBroker.command.Command;
import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.fwk.CommandManager;
import com.kadet.kadetBroker.fwk.CommandSender;
import com.kadet.kadetBroker.fwk.PropertiesManager;
import com.kadet.kadetBroker.to.CustomersListTO;
import com.kadet.kadetBroker.util.Strings;
import org.junit.Test;

public class TestSelectCustomersFromServer {

    @Test
    public void bigGet () throws KadetException {
/*
        PropertiesManager propertiesManager = PropertiesManager.getInstance();
        propertiesManager.initProperties();

        for (int threadIndex = 0; threadIndex < 1000; ++threadIndex) {

            GetAllCustomersCommand getCustomerCommand = (GetAllCustomersCommand) CommandManager.getInstance().newCommand(Strings.GET_ALL_CUSTOMERS_COMMAND);

            try {
                CommandSender commandSender = new CommandSender(1994, "localhost");
                commandSender.send(getCustomerCommand);
                Command command = (Command) commandSender.receive();
                // answerCommand.execute();
                // commandSender.close();

                CustomersListTO answer = (CustomersListTO) command.getResult();
                System.out.println("Size : " + answer.getCustomerTOsList().size());
            } catch (KadetException e) {
                e.printStackTrace();
            } catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        }
*/
    }

}
