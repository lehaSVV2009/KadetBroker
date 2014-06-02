package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.command.Command;
import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.rmi.Servlet;
import com.kadet.kadetBroker.rmi.ServletContainer;
import com.kadet.kadetBroker.rmi.RMIUtils;
import com.kadet.kadetBroker.to.MacSystemTO;
import com.kadet.kadetBroker.util.Strings;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistryManager {

    private static Logger logger = Logger.getLogger(RegistryManager.class.getName());

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

            logger.log(Level.SEVERE, Strings.CAN_NOT_GET_DATA_FROM_SERVER + ":" + e);
            throw new KadetException(Strings.CAN_NOT_GET_DATA_FROM_SERVER);

        } catch (NotBoundException e) {

            logger.log(Level.SEVERE, Strings.CAN_NOT_GET_DATA_FROM_SERVER + ":" + e);
            throw new KadetException(Strings.CAN_NOT_GET_DATA_FROM_SERVER);

        } catch (MalformedURLException e) {

            logger.log(Level.SEVERE, Strings.CAN_NOT_GET_DATA_FROM_SERVER + ":" + e);
            throw new KadetException(Strings.CAN_NOT_GET_DATA_FROM_SERVER);

        }

    }
    
	
}
