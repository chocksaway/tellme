package com.chocksaway.telnet.command;

public class ExitHandler implements CommandHandler {

    /*
     * (non-Javadoc)
     * 
     * @see com.chocksaway.telnet.command.CommandHandler#handle()
     */
    @Override
    public String handle() {

        return "Goodbye...";
    }

}
