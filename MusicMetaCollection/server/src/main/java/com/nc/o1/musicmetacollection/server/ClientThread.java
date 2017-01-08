package com.nc.o1.musicmetacollection.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author SteVL
 */
public class ClientThread implements Runnable {

    private Socket socket;

    private DataInputStream dis;
    private DataOutputStream dos;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        String inputMsg, outputMsg;
        while (socket != null) {
            try {
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
                System.out.println("Waiting for messages");
                while (true) {
                    inputMsg = dis.readUTF();
                    System.out.println("client: " + inputMsg);
                    if (inputMsg.equalsIgnoreCase(ServerHello.SRV_MSG)) {
                        outputMsg = "Correct string";
                    } else {
                        outputMsg = "Incorrect string";
                    }
                    dos.writeUTF("Server: " + inputMsg + " " + outputMsg);
                }
            } catch (IOException ex) {
                System.out.println("Connection is lost.");
            } finally {
                try {
                    dis.close();
                    dos.close();
                    socket.close();
                    socket = null;
                    System.out.println("Client disconnected.");
                } catch (IOException ex) {
                    //
                }
            }
        }
    }

}
