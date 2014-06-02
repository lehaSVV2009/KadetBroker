package com.kadet.kadetBroker.command;

import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.to.SystemTO;
import com.kadet.kadetBroker.to.TO;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Date: 22.05.14
 * Time: 0:39
 *
 * @author SarokaA
 */
public interface Command extends Remote {

    public TO getResult () throws RemoteException;
    public void setTO (TO to) throws RemoteException;
    public void setSystemTO (SystemTO systemTO) throws RemoteException;
    public void execute () throws RemoteException;
    public KadetException getException () throws RemoteException;

}
