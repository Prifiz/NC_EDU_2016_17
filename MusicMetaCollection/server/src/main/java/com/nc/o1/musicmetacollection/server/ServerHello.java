package com.nc.o1.musicmetacollection.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author SteVL
 */
public class ServerHello {

    static ServerSocket ss;
    static Socket s;
    static DataInputStream dis;
    static DataOutputStream dos;

    public static void main(String[] args) throws IOException  {
       
            System.out.println("Starting server...");
            final String SRV_MSG = "Hello from Server!";
            ss = new ServerSocket(1234);          
            System.out.println("Waiting for a client...");            
            s = ss.accept();
            System.out.println("Client connected");
            dis = new DataInputStream(s.getInputStream());
            dos = new DataOutputStream(s.getOutputStream());
            System.out.println("Waiting for messages");
            String msgin, msgout;
            while (true) {
                msgin = dis.readUTF();
                System.out.println("client: " + msgin);
                if (msgin.equalsIgnoreCase("stop")) {
                    dos.writeUTF("Server: Server stopped.");
                    break;
                }
                if (msgin.equalsIgnoreCase(SRV_MSG)) {
                    msgout = "Correct string";
                } else {
                    msgout = "Incorrect string";
                }
                dos.writeUTF("Server: " + msgin + " " + msgout);
            }   dis.close();
            dos.close();
            ss.close();
            s.close();
        
    }
}
