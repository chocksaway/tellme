package com.chocksaway.telnet.server;

public class ServerLauncher {

    /**
     * Main
     * Server wrapper
     * 
     * @param args
     */
    public static void main(String[] args) {
        // launch the server
        new Server(args.length == 0 ? null : args[0]).run();
    }
}
