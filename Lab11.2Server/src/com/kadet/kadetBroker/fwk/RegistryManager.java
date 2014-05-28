package com.kadet.kadetBroker.fwk;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.kadet.kadetBroker.util.RMIUtils;

public class RegistryManager {

	private static RegistryManager instance = new RegistryManager();

    public static RegistryManager getInstance () {
        return instance;
    }

    private RegistryManager () {
    	try {
    		registry = LocateRegistry.createRegistry(RMIUtils.port);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private Registry registry;
    
    public void registryRemote(String name, Remote remote) {
    	
    	try {
    		registry.rebind(name, remote);
    		
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	
    }
    
	
}
