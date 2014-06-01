package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.command.Command;
import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.rmi.Servlet;
import com.kadet.kadetBroker.rmi.ServletContainer;
import com.kadet.kadetBroker.rmi.RMIUtils;
import com.kadet.kadetBroker.to.MacSystemTO;
import com.kadet.kadetBroker.to.SystemTO;
import com.kadet.kadetBroker.util.Strings;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RegistryManager {

	private static RegistryManager instance = new RegistryManager();

    public static RegistryManager getInstance () {
        return instance;
    }

    private RegistryManager () {}

    private Servlet servlet;

    public Command getCommand (String commandName) throws KadetException {

    	try {
            ServletContainer servletContainer = (ServletContainer) Naming.lookup(RMIUtils.RMI_KADET_BROKER_SERVER);
            servlet = servletContainer.getServlet();
            Command command = servlet.getCommand(commandName);
            command.setSystemTO(new MacSystemTO());
            return command;
		} catch (RemoteException e) {
			e.printStackTrace();
			throw new KadetException(Strings.RMI_LOOKUP_EXCEPTION);
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new KadetException(Strings.RMI_LOOKUP_EXCEPTION);
		} catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            throw new KadetException(Strings.RMI_LOOKUP_EXCEPTION);
        }

    }
    
	
}
