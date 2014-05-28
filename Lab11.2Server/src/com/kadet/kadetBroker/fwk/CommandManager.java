package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.command.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 22.05.14
 * Time: 1:48
 *
 * @author SarokaA
 */
public class CommandManager {

    private final static CommandManager instance = new CommandManager();

    public static CommandManager getInstance () {
        return instance;
    }

    private CommandManager() {}

    private List<Command> commands = new ArrayList<Command>();

    public Command newCommand (String commandName) {
        String commandClassName = ServerPropertiesManager.getInstance().getCommandClassName(commandName);
        System.out.println("CommandClassName:" + commandClassName);
        Command command = CommandFactory.getInstance().createCommand(commandClassName);
        commands.add(command);
        return command;
    }

    /*public void executeCommand (Command command) {
        try {
            CommandSender commandSender = new CommandSender(1994, "localhost");
            commandSender.send(command);
            Command answerCommand = (Command) commandSender.receive();
            answerCommand.execute();
            commandSender.close();
        } catch (KadetException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
			e.printStackTrace();
		}
    }*/

}
