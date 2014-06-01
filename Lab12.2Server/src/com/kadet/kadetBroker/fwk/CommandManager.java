package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.command.Command;
import com.kadet.kadetBroker.util.Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Date: 22.05.14
 * Time: 1:48
 *
 * @author SarokaA
 */
public class CommandManager {

    private static Logger logger = Logger.getLogger(CommandManager.class.getName());

    private final static CommandManager instance = new CommandManager();

    public static CommandManager getInstance () {
        return instance;
    }

    private CommandManager() {}

    private List<Command> commands = new ArrayList<Command>();

    public Command newCommand (String commandName) {
        String commandClassName = ServerPropertiesManager.getInstance().getCommandClassName(commandName);
        Command command = CommandFactory.getInstance().createCommand(commandClassName);
        commands.add(command);
        logger.log(Level.INFO, Strings.NEW_COMMAND_WAS_CREATED, command);
        return command;
    }


}
