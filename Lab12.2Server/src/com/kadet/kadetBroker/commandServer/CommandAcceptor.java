package com.kadet.kadetBroker.commandServer;

import com.kadet.kadetBroker.command.Command;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Date: 22.05.14
 * Time: 1:10
 *
 * @author SarokaA
 */
public class CommandAcceptor {

    private final static CommandAcceptor instance = new CommandAcceptor();

    public static CommandAcceptor getInstance () {
        return instance;
    }

    private ServerSocket serverSocket;
    private int port;

    private CommandAcceptor () {
    }

    public void init (int port) {
        this.port = port;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println
                    ("Server created SeverSocket on port " + port);
            acceptConnection();
        } catch (Exception e) {
            System.out.println("Server.constructor: " + e);
        }
    }

    private void acceptConnection () {
        System.out.println("NwServer.acceptConnection ");
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept(); // listening;
                System.out.println("AFTER SERVER SOCKET!");
                System.out.println("Server.acceptCon + accepted");
                service(clientSocket);
            } catch (Exception e) {
//                System.out.println("NwServer.acceptCon " + e);
            }
        }
    }

    private void service (Socket socket) {
    	CommandServer.getInstance().service(socket);
    }


}
