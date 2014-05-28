package com.kadet.kadetBroker.rmi;

import com.kadet.kadetBroker.command.Command;
import com.kadet.kadetBroker.fwk.CommandManager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Date: 28.05.14
 * Time: 3:52
 *
 * @author SarokaA
 */
public class SessionImpl extends UnicastRemoteObject implements Session {

    public SessionImpl() throws RemoteException {
    }

    @Override
    public Command getCommand(String commandName) throws RemoteException {
        System.out.println("CommandName in Session: " + commandName);
        return CommandManager.getInstance().newCommand(commandName);
    }
}
