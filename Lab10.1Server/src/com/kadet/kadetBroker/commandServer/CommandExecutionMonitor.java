package com.kadet.kadetBroker.commandServer;

import java.util.concurrent.ThreadPoolExecutor;

public class CommandExecutionMonitor implements Runnable {

	private ThreadPoolExecutor executor;

	public CommandExecutionMonitor (ThreadPoolExecutor executor) {
		this.executor = executor;
	}

	@Override
	public void run() {
		try {
			do {
				System.out.println(
						String.format("[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
								this.executor.getPoolSize(),
								this.executor.getCorePoolSize(),
								this.executor.getActiveCount(),
								this.executor.getCompletedTaskCount(),
								this.executor.getTaskCount(),
								this.executor.isShutdown(),
								this.executor.isTerminated()));
				Thread.sleep(3000);
			}
			while (true);
		} catch (Exception e) {}
	}

}
