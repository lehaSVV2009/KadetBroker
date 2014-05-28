package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.rmi.ServerImpl;
import com.kadet.kadetBroker.util.RMIUtils;

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

        /*int port = 0;
        try {
            port = ServerPropertiesManager.getInstance().getPort();
            CommandAcceptor.getInstance().init(port);
        } catch (KadetException e) {
            e.printStackTrace();
        }*/
    	registryServer();
    	
    	while (true) {
    		
    	}

    }
    
    private void registryServer () {
    	RegistryManager registryManager = RegistryManager.getInstance();
    	/*CommandFactory commandFactory = CommandFactory.getInstance();
    	registryManager.registryRemote(RMIUtils.RMI_ADD_CUSTOMER, commandFactory.createCommand(AddCustomerCommand.class.getName()));
    	registryManager.registryRemote(RMIUtils.RMI_REMOVE_CUSTOMER, commandFactory.createCommand(RemoveCustomerCommand.class.getName()));
    	registryManager.registryRemote(RMIUtils.RMI_GET_ALL_CUSTOMERS, commandFactory.createCommand(GetAllCustomersCommand.class.getName()));
    	registryManager.registryRemote(RMIUtils.RMI_UPDATE_CUSTOMER, commandFactory.createCommand(UpdateCustomerCommand.class.getName()));
    	registryManager.registryRemote(RMIUtils.RMI_GET_PORTFOLIO, commandFactory.createCommand(GetPortfolioCommand.class.getName()));
    	registryManager.registryRemote(RMIUtils.RMI_GET_ALL_STOCKS, commandFactory.createCommand(GetAllStocksCommand.class.getName()));
    	*/
        registryManager.registryRemote(RMIUtils.RMI_KADET_BROKER_SERVER, ServerImpl.getInstance());
    }


}
