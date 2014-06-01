package com.kadet.kadetBroker.test;

import com.kadet.kadetBroker.command.Command;
import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.fwk.RegistryManager;
import com.kadet.kadetBroker.to.CustomerTO;
import com.kadet.kadetBroker.rmi.RMIUtils;
import org.junit.Test;

import java.rmi.RemoteException;

/**
 * Date: 28.05.14
 * Time: 2:46
 *
 * @author SarokaA
 */
public class RmiTest {

    @Test
    public void rmiTest () throws KadetException, RemoteException {

        RegistryManager registryManager = RegistryManager.getInstance();
        Command customersCommand = registryManager.getCommand(RMIUtils.RMI_GET_ALL_CUSTOMERS);
        Command customersCommand2 = registryManager.getCommand(RMIUtils.RMI_GET_ALL_CUSTOMERS);
        CustomerTO customerTO = new CustomerTO();
        customerTO.setId("xxx");
        customersCommand2.setTO(customerTO);
        customersCommand.execute();
    }


}
