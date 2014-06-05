package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.rmi.ServletContainerImpl;
import com.kadet.kadetBroker.rmi.RMIUtils;
import com.kadet.kadetBroker.util.Strings;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Date: 22.05.14
 * Time: 0:59
 *
 * @author SarokaA
 */
public class ServerLauncher {

    private static Logger logger = Logger.getLogger(ServerLauncher.class.getName());

    private static ServerLauncher instance = new ServerLauncher();

    public static ServerLauncher getInstance() {
        return instance;
    }

    private ServerLauncher() {
    }

    public void launchServer() {

        registryServer();

        while (true) {

        }

    }

    /**
     *      Register ServletContainer in the LocalRegistry
     */
    private void registryServer () {
        RegistryManager registryManager = RegistryManager.getInstance();
        ServletContainerImpl servletContainer = ServletContainerImpl.getInstance();
        registryManager.registryRemote(RMIUtils.RMI_KADET_BROKER_SERVER, servletContainer);
        logger.log(Level.FINE, Strings.SERVLET_CONTAINER_WAS_REGISTERED, servletContainer);
    }


}
