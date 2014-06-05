package com.kadet.kadetBroker.rmi;

import com.kadet.kadetBroker.fwk.SessionFactory;
import com.kadet.kadetBroker.util.Strings;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Date: 28.05.14
 * Time: 3:51
 *
 * @author SarokaA
 */
public class ServletContainerImpl extends UnicastRemoteObject implements ServletContainer {

    private static Logger logger = Logger.getLogger(ServletContainerImpl.class.getName());

    private static ServletContainerImpl instance;

    static {
        try {
            instance = new ServletContainerImpl();
        } catch (RemoteException e) {
            logger.log(Level.SEVERE, Strings.CAN_NOT_CREATE_SERVLET_CONTAINER);
        }
    }

    public static ServletContainerImpl getInstance() {
        return instance;
    }

    private ServletContainerImpl() throws RemoteException {
        super();
    }

    private List<ServletImpl> servlets = new ArrayList<ServletImpl>();


    /**
     *
     *  If servlet container has any not overloaded servlet, it will return this servlet
     *  If it is no any, it will return new Servlet
     *
     */
    @Override
    public synchronized Servlet getServlet() throws RemoteException {
        ServletImpl chosenServlet = null;
        for (ServletImpl servlet : servlets) {
            if (servlet.lessThanLimitNumberOfUsers()) {
                chosenServlet = servlet;
                break;
            }
        }
        if (chosenServlet == null) {
            chosenServlet = new ServletImpl();
            registerServlet(chosenServlet);
        }
        return chosenServlet;
    }


    private void registerServlet(ServletImpl servlet) {
        servlets.add(servlet);
        logger.log(Level.INFO, Strings.NEW_SERVLET_WAS_CREATED, servlet);
    }
}
