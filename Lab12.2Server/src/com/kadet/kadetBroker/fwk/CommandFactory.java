package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.command.Command;

/**
 * Date: 22.05.14
 * Time: 4:06
 *
 * @author SarokaA
 */
public class CommandFactory {


    private final static CommandFactory instance = new CommandFactory();

    public static CommandFactory getInstance () {
        return instance;
    }

    private CommandFactory() {}

    public static Command createCommand (String className) {
        try {
            return (Command) Class.forName(className).newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to instantiate" + className);
        }
    }
    
}
