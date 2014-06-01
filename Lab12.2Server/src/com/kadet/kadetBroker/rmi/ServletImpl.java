package com.kadet.kadetBroker.rmi;

import com.kadet.kadetBroker.command.Command;
import com.kadet.kadetBroker.fwk.CommandManager;
import com.kadet.kadetBroker.to.SystemTO;
import com.kadet.kadetBroker.to.TO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Date: 28.05.14
 * Time: 3:52
 *
 * @author SarokaA
 */
public class ServletImpl extends UnicastRemoteObject implements Servlet {

    private final static int limitNumberOfUsers = 10;
    private int numberOfUsers = 0;

    public ServletImpl() throws RemoteException {
    }

    public void increaseNumberOfUsers () {
        ++numberOfUsers;
    }

    public void decreaseNumberOfUsers () {
        --numberOfUsers;
    }

    public boolean lessThanLimitNumberOfUsers() {
        return numberOfUsers <= limitNumberOfUsers;
    }

    @Override
    public Command getCommand(String s) throws RemoteException {
        try {
            increaseNumberOfUsers();
            return CommandManager.getInstance().newCommand(s);
        } finally {
            decreaseNumberOfUsers();
        }
    }
}
