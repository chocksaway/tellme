package com.chocksaway.telnet.command;

import java.io.File;
import java.util.logging.Logger;

public class MKDIRHandler implements CommandHandler {

    private final String command;
    private final Logger logger = Logger.getLogger(MKDIRHandler.class.getName());
    private final String workingDir;

    public MKDIRHandler(final String command, String workingDir) {
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
        boolean created = false;
        final String newDir = command.split(" ", 2)[1];

        // handling directory creation from an absolute path
        if (newDir.startsWith("/") || newDir.matches("(C|c):.*")) {
            created = new File(newDir).mkdirs();
        } else {
            created = new File(workingDir + File.separator + newDir).mkdirs();
        }
        return created ? "Directory [" + newDir + "] has been successfully created"
                : "Failed to created the following directory: " + newDir
                        + ". Check the path exist or you have the right permissions";

    }

}
