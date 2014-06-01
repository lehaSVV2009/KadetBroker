package com.kadet.kadetBroker;

import java.rmi.RemoteException;

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

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }


}

//Proxy[Command,RemoteObjectInvocationHandler[UnicastRef [liveRef: [endpoint:[172.18.2.110:51283](remote),objID:[-6fa6399d:1463eea4fbf:-7ffd, -6927511382530192011]]]]]