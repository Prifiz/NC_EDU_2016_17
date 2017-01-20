package com.nc.o1.musicmetacollection.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.apache.log4j.Logger;

/**
 *
 * @author Слава
 */
public class Hello extends JFrame {

    public static final Logger log = Logger.getLogger(Hello.class);

    public static MainFrame mainFrame;

    private static Socket socket;
    private static DataInputStream dis;
    private static DataOutputStream dos;

    private JButton sendServerButton;
    private JLabel responseServerLabel;
    private JTextField msgToServerInput;

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

        msgToServerInput = new JTextField();
        msgToServerInput.setSize(100, 30);
        msgToServerInput.setLocation(200, 400);
        panel.add(msgToServerInput);

        responseServerLabel = new JLabel();
        responseServerLabel.setSize(300, 30);
        responseServerLabel.setLocation(200, 380);
        panel.add(responseServerLabel);

        sendServerButton = new JButton("Test connection");
        sendServerButton.setSize(150, 30);
        sendServerButton.setLocation(400, 400);
        panel.add(sendServerButton);
        sendServerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Server test button pressed.");
                try {
                    String msgout = msgToServerInput.getText();
                    dos.writeUTF(msgout);
                    String msgin = dis.readUTF();
                    //inputTestCon.setText(msgin);
                    responseServerLabel.setText(msgin);
                } catch (IOException ex) {
                    System.out.println("******Exception: after button pressed. " + ex);
                } catch (NullPointerException ex) {
                    //
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
        socket = null;
        try {
            socket = new Socket("127.0.0.1", 1234);
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            System.out.println("Waiting messages to server");
        } catch (IOException ex) {
            if (log.isDebugEnabled()) {
                log.debug("Error:********* " + ex);
            }
            JOptionPane.showMessageDialog(null, "There is no connection. Offline mode.");
        }
    }
}
