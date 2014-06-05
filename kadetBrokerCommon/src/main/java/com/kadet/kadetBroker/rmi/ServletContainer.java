package com.kadet.kadetBroker.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Date: 28.05.14
 * Time: 3:29
 *
 * @author SarokaA
 */
public interface ServletContainer extends Remote {

    public Servlet getServlet () throws RemoteException;

}
