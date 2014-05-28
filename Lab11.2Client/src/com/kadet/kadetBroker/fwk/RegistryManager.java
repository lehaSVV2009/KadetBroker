package com.kadet.kadetBroker.fwk;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import com.kadet.kadetBroker.command.Command;
import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.rmi.Server;
import com.kadet.kadetBroker.rmi.Session;
import com.kadet.kadetBroker.util.RMIUtils;
import com.kadet.kadetBroker.util.Strings;

public class RegistryManager {

	private static RegistryManager instance = new RegistryManager();

    public static RegistryManager getInstance () {
        return instance;
    }

    private RegistryManager () {}

    private Session session;

    public Command getCommand (String commandName) throws KadetException {

    	try {
            if (session != null) {
                return session.getCommand(commandName);
            }
			Server server = (Server) Naming.lookup(RMIUtils.RMI_KADET_BROKER_SERVER);
            session = server.getSession();
            return session.getCommand(commandName);
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
			throw new KadetException(Strings.RMI_LOOKUP_EXCEPTION);
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new KadetException(Strings.RMI_LOOKUP_EXCEPTION);
		}
    	
    }
    
	
}
