package com.SfinderServer;

import com.communication.*;

/**
 * Entry Point
 *
 */
public class App {
    public static void main( String[] args ) {
        System.out.println( "Application Started..." );
        TCPServer ts = new TCPServer();
        ts.runServer();
    }
}
