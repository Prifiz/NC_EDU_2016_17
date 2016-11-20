/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nc.o1.musicmetacollection.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Слава
 */
public class Hello extends JFrame {

    public static MainFrame mainFrame;

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
        JButton button = new JButton("Далее");
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
    }
}
