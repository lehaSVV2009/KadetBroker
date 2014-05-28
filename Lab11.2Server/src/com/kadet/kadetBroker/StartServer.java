package com.kadet.kadetBroker;

import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.fwk.ServerLauncher;
import com.kadet.kadetBroker.fwk.ServerPropertiesManager;
import com.kadet.kadetBroker.util.Strings;

/**
 * Date: 22.05.14
 * Time: 0:47
 *
 * @author SarokaA
 */
public class StartServer {

    public static void main (String[] args) {

        System.out.println("Server Starts!");
        ServerPropertiesManager propertiesManager = ServerPropertiesManager.getInstance();
        try {

            propertiesManager.initProperties();
            ServerLauncher.getInstance().launchServer();
            System.out.println("Server was started!");
            
        } catch (KadetException e) {
            e.printStackTrace();
        }

    }

}
