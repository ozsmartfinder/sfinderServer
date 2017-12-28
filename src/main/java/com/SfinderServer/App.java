package com.SfinderServer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.communication.*;
import com.hibernate.data.UserInfo;

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
