package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.commandServer.CommandAcceptor;
import com.kadet.kadetBroker.exception.KadetException;

/**
 * Date: 22.05.14
 * Time: 0:59
 *
 * @author SarokaA
 */
public class ServerLauncher {

    private static ServerLauncher instance = new ServerLauncher();

    public static ServerLauncher getInstance () {
        return instance;
    }

    private ServerLauncher () {}

    public void launchServer () {

        int port = 0;
        try {
            port = ServerPropertiesManager.getInstance().getPort();
            CommandAcceptor.getInstance().init(port);
        } catch (KadetException e) {
            e.printStackTrace();
        }

    }


}
