package com.kadet.kadetBroker.rmi;

import com.kadet.kadetBroker.fwk.SessionFactory;
import com.kadet.kadetBroker.rmi.Server;
import com.kadet.kadetBroker.rmi.Session;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Date: 28.05.14
 * Time: 3:51
 *
 * @author SarokaA
 */
public class ServerImpl extends UnicastRemoteObject implements Server {

    private static ServerImpl instance;

    static {
        try {
            instance = new ServerImpl();
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public static ServerImpl getInstance () {
        return instance;
    }


    protected ServerImpl() throws RemoteException {
    }


    @Override
    public synchronized Session getSession() throws RemoteException {
        return SessionFactory.getInstance().createSession(SessionImpl.class.getName());
    }
}
