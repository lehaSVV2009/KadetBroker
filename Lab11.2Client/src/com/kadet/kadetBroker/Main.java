package com.kadet.kadetBroker;

import com.kadet.kadetBroker.command.*;
import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.fwk.CommandManager;
import com.kadet.kadetBroker.fwk.CommandSender;
import com.kadet.kadetBroker.fwk.PropertiesManager;
import com.kadet.kadetBroker.to.CustomerTO;
import com.kadet.kadetBroker.util.Strings;

import java.rmi.RemoteException;
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

        try {
			AppBundle bundle1 = new AppBundle();
			AppBundle bundle2 = new AppBundle();
			AppBundle bundle3 = new AppBundle();
			AppBundle bundle4 = new AppBundle();

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }


}

//Proxy[Command,RemoteObjectInvocationHandler[UnicastRef [liveRef: [endpoint:[172.18.2.110:51283](remote),objID:[-6fa6399d:1463eea4fbf:-7ffd, -6927511382530192011]]]]]