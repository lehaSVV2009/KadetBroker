package com.kadet.kadetBroker;

import com.kadet.kadetBroker.command.*;
import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.fwk.CommandManager;
import com.kadet.kadetBroker.fwk.CommandSender;
import com.kadet.kadetBroker.fwk.PropertiesManager;
import com.kadet.kadetBroker.to.CustomerTO;
import com.kadet.kadetBroker.util.Strings;

import java.util.Random;

/**
 * Date: 22.05.14
 * Time: 1:41
 *
 * @author SarokaA
 */
public class Main {

    public static void main (String[] args) {

        System.out.println("Client");

        AppBundle bundle = new AppBundle();







        /*CustomerTO customerTO = new CustomerTO();
        customerTO.setId("id1Client");
        customerTO.setName("name1Client");
        customerTO.setAddress("name1Client");

        AddCustomerCommand command = new AddCustomerCommand();
        command.setToServer(customerTO);

        CommandManager.getInstance().sendObject(command);*/

    }


}
