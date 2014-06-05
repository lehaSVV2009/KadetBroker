package com.kadet.kadetBroker;

import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.fwk.ServerLauncher;
import com.kadet.kadetBroker.fwk.ServerPropertiesManager;
import com.kadet.kadetBroker.util.Strings;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Date: 22.05.14
 * Time: 0:47
 *
 * @author SarokaA
 */
public class StartServer {

    private static Logger logger = Logger.getLogger(StartServer.class.getName());

    public static void main (String[] args) {

        System.out.println("Server Starts!");
        ServerPropertiesManager propertiesManager = ServerPropertiesManager.getInstance();
        try {

            propertiesManager.initProperties();
            ServerLauncher.getInstance().launchServer();
            
        } catch (KadetException e) {
            logger.log(Level.INFO, Strings.INITIALIZE_EXCEPTION + ":" + e);
        }

    }

}
