package com.chocksaway.telnet.command;

import java.util.logging.Logger;

public class PWDHandler implements CommandHandler {

    private final String command;
    private final Logger logger = Logger.getLogger(PWDHandler.class.getName());
    private final String workingDir;

    public PWDHandler(final String command, String workingDir) {
        this.command = command;
        this.workingDir = workingDir;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.chocksaway.telnet.command.CommandHandler#handle()
     */
    @Override
    public String handle() {

        logger.info("running the following command:" + command);
        return workingDir;

    }

}
