/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nc.o1.musicmetacollection.view;

import com.nc.o1.musicmetacollection.controller.Controller;
import java.awt.Color;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTextArea;


/**
 *
 * @author VellkyPie
 */
public class HelpDialog extends javax.swing.JDialog{
    
    public HelpDialog(java.awt.Frame parent, boolean modal) throws ParseException {
        super(parent, modal);
        this.setTitle("Help - MusicMetaCollection");
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setLayout(null);

        try {
            String text=Controller.readHelp().toString();
            
            JTextArea textlab=new JTextArea(text);
            textlab.setBackground(Color.white);
            textlab.setSize(700, 600);
            textlab.setLocation(0,0);
            panel.add(textlab);
        } catch (IOException ex) {
            Logger.getLogger(HelpDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        setContentPane(panel);

        setSize(700, 600);
        
        
    }
}
