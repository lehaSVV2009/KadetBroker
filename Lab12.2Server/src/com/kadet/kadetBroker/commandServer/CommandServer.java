package com.kadet.kadetBroker.commandServer;

import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CommandServer {
	
    private static CommandServer instance = new CommandServer();

    public static CommandServer getInstance () {
        return instance;
    }

    private int coresNumber = Runtime.getRuntime().availableProcessors();
    
    private int maximumPoolSize = coresNumber + 1;
    
    private int keepAliveTime = 10;
    
    private BlockingQueue<Runnable> worksQueue = new ArrayBlockingQueue<Runnable>(2);
    
    private RejectedExecutionHandler executionHandler = new CommandExecutionHandler();
    

    private ThreadPoolExecutor threadPoolExecutor;

    private CommandServer () {
        System.out.println("Cores number: " + coresNumber);
        threadPoolExecutor = new ThreadPoolExecutor(coresNumber,
                maximumPoolSize,
                keepAliveTime,
                TimeUnit.SECONDS,
                worksQueue,
                executionHandler);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    
    
    public void service(Socket socket) {
    	CommandThread commandThread = new CommandThread(socket);
//        commandThread.run();
    	threadPoolExecutor.execute(commandThread);
	}
    
}
