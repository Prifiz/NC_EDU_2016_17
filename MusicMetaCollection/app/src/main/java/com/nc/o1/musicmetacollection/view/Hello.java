/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nc.o1.musicmetacollection.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Слава
 */
public class Hello extends JFrame {

    public static MainFrame mainFrame;

    private static Socket s;
    private static DataInputStream dis;
    private static DataOutputStream dos;

    /**
     * Button sends data to server.
     */
    private JButton srvBtn;
    /**
     * Label for server response.
     */
    private JLabel srvResponseLabel;
    /**
     * Input field for test connection with server.
     */
    private JTextField inputTestCon;

    public Hello() {
        super("Start Page - MusicMetaCollection");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setBackground(Color.lightGray);
        panel.setLayout(null);

        JLabel label = new JLabel("Hello!");

        Font font = new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 25);
        label.setFont(font);
        label.setSize(300, 150);
        label.setLocation(321, 200);
        panel.add(label);

        inputTestCon = new JTextField();
        inputTestCon.setSize(100, 30);
        inputTestCon.setLocation(200, 400);
        panel.add(inputTestCon);

        srvResponseLabel = new JLabel();
        srvResponseLabel.setSize(300, 30);
        srvResponseLabel.setLocation(200, 380);
        panel.add(srvResponseLabel);

        srvBtn = new JButton("Test connection");
        srvBtn.setSize(150, 30);
        srvBtn.setLocation(400, 400);
        panel.add(srvBtn);
        srvBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String msgout = inputTestCon.getText();
                    dos.writeUTF(msgout);
                    String msgin = dis.readUTF();
                    //inputTestCon.setText(msgin);
                    srvResponseLabel.setText(msgin);
                } catch (IOException ex) {
                    Logger.getLogger(Hello.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        JButton button = new JButton("Next");
        button.setBackground(Color.white);
        button.setSize(80, 30);
        button.setLocation(312, 520);
        panel.add(button);
        setContentPane(panel);
        setSize(700, 600);
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                mainFrame = new MainFrame();
                mainFrame.setResizable(false);
                dispose();
            }
        });

    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Hello hello = new Hello();
                hello.setVisible(true);
                hello.setResizable(false);
            }
        });
        System.out.println("Starting client...");

        String msgout;

        s = null;
        try {
            s = new Socket("127.0.0.1", 1234);
            dis = new DataInputStream(s.getInputStream());
            dos = new DataOutputStream(s.getOutputStream());
            System.out.println("Waiting messages to server");
            
        } catch (IOException ex) {
            System.err.println("Error:********* " + ex);
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Server isn't running. Restart app with running server before.");
        }

        //      Scanner sc = new Scanner(System.in);
/*
        while(true) {
            System.out.print("Msg: ");
            msgout = sc.nextLine();
            
            dos.writeUTF(msgout);
            if(msgout.equalsIgnoreCase("stop")){
                break;
            }
            System.out.println(dis.readUTF());
        }
         */
    }
}
