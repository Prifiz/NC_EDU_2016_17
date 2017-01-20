package com.nc.o1.musicmetacollection.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import org.apache.log4j.Logger;

/**
 * Server checks string recieved from clients.
 *
 * @author SteVL
 */
public class ServerHello implements Runnable {
    
    public static final Logger log=Logger.getLogger(ServerHello.class);

    private volatile boolean stopFlag;

    final static String SRV_MSG = "Hello from Server!";

    private ServerSocket serverSocket;

    public void showHelp() {
        String[] help = {"start", "stop", "quit"};
        System.out.println("Available commands");
        for (int i = 0; i < help.length; i++) {
            System.out.println(help[i]);
        }
    }

    public void startServer() {
        System.out.println("Starting server..");
        stopFlag = false;
        new Thread(this).start();

    }

    public void stopServer() {
        if (stopFlag == false) {
            System.out.println("Stopping server..");
            stopFlag = true;
            
        } else {
            System.out.println("Server isn't running.");
        }
    }

    public void restartServer() {
       
    }

    @Override
    public void run() {
        System.out.println("Server is started");
        try {
            serverSocket = new ServerSocket(1234);
            if (log.isDebugEnabled()) {
                log.debug("ServerSocket on the port 1234 is created.");
            }
            serverSocket.setSoTimeout(1 * 1000);
            Socket socket = null;
            System.out.println("Waiting first client..");
            while (!stopFlag) {
                try {
                    socket = serverSocket.accept();
                    //may be exception of recieving data by server on the client side.
                    new Thread(new ClientThread(socket)).start();
                } catch (java.net.SocketTimeoutException timeOutEx) {
                    if (stopFlag) {
                        break;
                    }
                }
            }
            serverSocket.close();
            System.out.println("Server is stopped.");
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        System.out.println("-----------------------");
        System.out.println("Server Manager");
        System.out.println("-----------------------");

        ServerHello server = new ServerHello();
        if (log.isDebugEnabled()) {
            log.debug("server object created.");
        }
        Scanner sc = new Scanner(System.in);
        String command = "";
        System.out.println("Send command 'help' to show available commands.");
        do {
            command = sc.nextLine();
            switch (command) {
                case "help":
                    server.showHelp();
                    break;
                case "start":
                    server.startServer();
                    break;
                case "restart":
                    break;
                case "stop":
                    server.stopServer();
                    break;
                case "quit":
                    break;
            }
        } while (!"quit".equals(command));
    }

}
