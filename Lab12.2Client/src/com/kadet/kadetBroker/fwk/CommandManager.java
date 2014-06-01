package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.command.Command;
import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.util.Strings;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.rmi.RemoteException;
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
        String commandClassName = PropertiesManager.getInstance().getCommandClassName(commandName);
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
