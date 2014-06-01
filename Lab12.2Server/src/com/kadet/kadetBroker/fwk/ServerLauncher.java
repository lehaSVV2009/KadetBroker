package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.rmi.ServletContainerImpl;
import com.kadet.kadetBroker.rmi.RMIUtils;

/**
 * Date: 22.05.14
 * Time: 0:59
 *
 * @author SarokaA
 */
public class ServerLauncher {

    private static ServerLauncher instance = new ServerLauncher();

    public static ServerLauncher getInstance () {
        return instance;
    }

    private ServerLauncher () {}

    public void launchServer () {

    	registryServer();
    	
    	while (true) {
    		
    	}

    }
    
    private void registryServer () {
    	RegistryManager registryManager = RegistryManager.getInstance();

        registryManager.registryRemote(RMIUtils.RMI_KADET_BROKER_SERVER, ServletContainerImpl.getInstance());
    }


}
