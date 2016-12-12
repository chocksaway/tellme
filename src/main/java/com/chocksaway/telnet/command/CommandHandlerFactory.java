package com.chocksaway.telnet.command;

import com.chocksaway.telnet.command.LSHandler;
import com.chocksaway.telnet.command.MKDIRHandler;
import com.chocksaway.telnet.command.PWDHandler;
import com.chocksaway.telnet.command.StatusHandler;

public class CommandHandlerFactory {

    private static CommandHandlerFactory factory;

    /**
     * Factory method.
     * 
     * @return
     */
    public static CommandHandlerFactory getInstance() {
        if (factory != null) {
            return factory;
        }
        return new CommandHandlerFactory();
    }

    /**
     * Get handler for given command.
     * 
     * @param command
     * @param workingDir
     * @return
     */
    public CommandHandler getHandler(final String command, final String workingDir) {
        if (command.matches("^cd .*")) {
            return new CDHandler(command, workingDir);
        } else if (command.matches("^ls.*")) {
            return new LSHandler(command, workingDir);
        } else if (command.matches("^pwd.*$")) {
            return new PWDHandler(command, workingDir);
        } else if (command.matches("^mkdir .*")) {
            return new MKDIRHandler(command, workingDir);
        } else if (command.equalsIgnoreCase("status")) {
            return new StatusHandler(command);
        } else if (command.equalsIgnoreCase("exit")) {
            return new ExitHandler();
        } else {
            return new UnknownCommandHandler(command);
        }

    }

}
