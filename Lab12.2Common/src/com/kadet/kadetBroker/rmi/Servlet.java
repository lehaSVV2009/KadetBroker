package com.kadet.kadetBroker.rmi;

import com.kadet.kadetBroker.command.Command;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Date: 28.05.14
 * Time: 3:42
 *
 * @author SarokaA
 */
public interface Servlet extends Remote {

    public Command getCommand (String commandName) throws RemoteException;

}
