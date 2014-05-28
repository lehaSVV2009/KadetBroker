package com.kadet.kadetBroker.commandServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.kadet.kadetBroker.command.Command;

public class CommandThread implements Runnable {

    private Socket socket;

    public CommandThread (Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run () {
        try {
            InputStream inputStream
                    = socket.getInputStream();
            ObjectInputStream objectInputStream
                    = new ObjectInputStream(inputStream);
            Object objectFromClient = null;
            while (objectFromClient == null) {
                objectFromClient = objectInputStream.readObject();
            }
            Command command = (Command) objectFromClient;
            command.execute();
            System.out.println("Server.executed command: " + command);
            OutputStream outputStream
                    = socket.getOutputStream();
            ObjectOutputStream objectOutputStream
                    = new ObjectOutputStream(outputStream);
            //while (true) {
            objectOutputStream.writeObject(command);
            //}
        } catch (Exception e) {

            e.printStackTrace();
            Logger.getGlobal().log(Level.SEVERE, "OBJECT HAS NOT SERIAL_VERSION_UID!!!");
            //TODO: close connection with Client

        } finally {

            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

}
