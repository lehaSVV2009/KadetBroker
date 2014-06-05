package com.kadet.kadetBroker.fwk;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.kadet.kadetBroker.rmi.RMIUtils;
import com.kadet.kadetBroker.util.Strings;

public class RegistryManager {


    private static RegistryManager instance = new RegistryManager();

    public static RegistryManager getInstance () {
        return instance;
    }

    private static Logger logger = Logger.getLogger(RegistryManager.class.getName());


    private RegistryManager() {
        try {
            registry = LocateRegistry.createRegistry(RMIUtils.port);
        } catch (RemoteException e) {
            logger.log(Level.SEVERE, Strings.CAN_NOT_CREATE_RMI_REGISTRY, e);
        }
    }

    private Registry registry;


    public void registryRemote(String name, Remote remote) {

        if (registry == null) {
            logger.log(Level.SEVERE, Strings.RMI_REGISTRY_WAS_NOT_CREATED);
            return;
        }
        try {
            registry.rebind(name, remote);
        } catch (RemoteException e) {
            logger.log(Level.SEVERE, Strings.CAN_NOT_REBIND_OBJECT, e);
        }

    }
	
}
