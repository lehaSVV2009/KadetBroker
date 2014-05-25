package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.command.Command;
import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.util.Strings;
import org.omg.DynamicAny._DynEnumStub;

import java.io.*;
import java.net.Socket;

/**
 * Date: 22.05.14
 * Time: 4:45
 *
 * @author SarokaA
 */
public class CommandSender {

    private Socket socket;
    private InputStream inputStream;
    private ObjectInputStream objectInputStream;
    private OutputStream outputStream;
    private ObjectOutputStream objectOutputStream;

    private String host;
    private int port;

    private int retry = 4;


    public CommandSender (int port, String host) {
        this.host = host;
        this.port = port;
        connect();
    }

    public void setHost (String host) {
        this.host = host;
    }

    public void setPort (int port) {
        this.port = port;
    }


    public void setRetry (int retry) {
        if (retry >= 0) {
            this.retry = retry;
        }
    }

    public void connect () {
        try {
            //** 1. Create a new Socket with host, port as parameters
            //**    and assign this socket to skt.
            socket = new Socket(host, port);
            //** 2. Invoke getInputStream method on skt and assign the
            //**    return value to is.
            inputStream = socket.getInputStream();
            //** 3. Assign null to ois.
            //Q? Why is ois not created here, but instead assigned
            //   to null?
            objectInputStream = null;
            //** 4. Invoke getOutputStream method on skt and assign
            //**     the return value to os.
            outputStream = socket.getOutputStream();
            //** 5. Create a new ObjectOutputStream object with os as
            //**    parameter and assign this newly created object
            //**    to oos.
            objectOutputStream = new ObjectOutputStream(outputStream);
        } catch (Exception e) {
            System.out.println("NwClient.connect: " + e);
        }
    }

    public void connect (String host, int port) {
        //** 1 Initialize the corresponding host attribute
        this.host = host;
        //** 2 Initialize the corresponding port attribute
        this.port = port;
        //** 3 Invoke the connect() method
        connect();
    }

    public void send (Object objectToServer) throws KadetException {
        preSending(objectToServer);
        retry = 10;
        while (retry > 0) {
            try {
                //** 1. Invoke the writeObject method of oos with
                //**    obj as parameter
                objectOutputStream.writeObject(objectToServer);
                retry = 0;
                System.out.println("NwClient.send: " + objectToServer + "sent");
            } catch (Exception e) {
                System.out.println("NwClient.send: " + e);
                retry--;
                if (retry == 0) {
                    throw new KadetException(Strings.CAN_NOT_SEND_DATA);
                }
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e1) {
                    throw new KadetException(Strings.THREAD_DOES_NOT_CAN_SLEEP);
                }
                connect();
            } finally {
                /*if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }*/
            }
        }
    }

    public Object receive () throws KadetException {
        preAnswer();
        Object answer = null;
        try {
            if (objectInputStream == null) {
                //** 1. Create a new ObjectInputStream object with is
                //**    as the input parameter. Assign this to ois.
                //Q? Why is ois created here, rather than in the connect
                //   method, where all the other streams are created?
                objectInputStream = new ObjectInputStream(inputStream);
            }
            int retry = 10;
            //** 2. Invoke the readObject method of ois and assign the
            //**    return value to obj
            while (retry > 0 && answer == null) {
                try {
                    answer = objectInputStream.readObject();
                } catch (EOFException e) {
                    e.printStackTrace();
                    System.out.println("EOF Exception!");
                    --retry;
                }
            }
            if (answer == null) {
                throw new KadetException("Answer does not can come from server!");
            }
            afterAnswer(answer);
        } catch (Exception e) {
            System.out.println("NwClient.receive: " + e);
//            connect();
            e.printStackTrace();
            throw new KadetException(Strings.CAN_NOT_RECEIVE_DATA);
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return answer;
    }

    public void close () {
        try {
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
    }

    protected void preSending (Object objectToServer) {

    }

    protected void preAnswer () {

    }

    protected void afterAnswer (Object answer) {

    }


    //TODO: Close socket if App Closed


}
