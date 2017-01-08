package com.nc.o1.musicmetacollection.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server checks string recieved from clients.
 * @author SteVL
 */
public class ServerHello {
    final static String SRV_MSG = "Hello from Server!";
    
    ServerHello() {
        startServer();
    }
    
    private void startServer() {
        System.out.println("Starting server...");
        try {
            ServerSocket srvSocket = new ServerSocket(1234);
            System.out.println("Waiting for a client...");
            Socket socket;
            while (true) {
                socket = srvSocket.accept();
                System.out.println("Client connected");
                ClientThread client = new ClientThread(socket);
                Thread thread=new Thread(client);
                thread.start();
            }
        } catch (IOException ex) {
           //
        }
    }
    public static void main(String[] args) {
        ServerHello server =new ServerHello();
    }
}
