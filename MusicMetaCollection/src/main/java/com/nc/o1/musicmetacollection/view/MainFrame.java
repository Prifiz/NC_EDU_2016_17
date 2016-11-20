/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nc.o1.musicmetacollection.view;

import com.nc.o1.musicmetacollection.model.TrackInfo;
import com.nc.o1.musicmetacollection.model.TrackList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Слава
 */
public class MainFrame extends JFrame {

    private final JMenuBar topMenu;

    private final JMenu fileMenu, fileSaveMenu, fileLoadMenu;
    private JFileChooser fileChooser = new JFileChooser();
    private final JMenuItem fileSaveXML, fileSaveSrlz;
    private final JMenuItem fileLoadXML, fileLoadSrlz;
    private final JMenuItem helpMenu;
    private final JMenuItem fileExit;

    TrackList allTracks, newTracks;
  //  String[][] data = new String[20][2];
    JTable table;
    //Массив, содержащий заголовки таблицы
  //  Object[] headers = {"Artist", "Title"};

    /**
     * Creates Main Window.
     */
    public MainFrame() {
        JFrame frame = new JFrame();
        //<editor-fold defaultstate="collapsed" desc="topMenu">
        topMenu = new JMenuBar();
        frame.setJMenuBar(topMenu);

        //Create menu File
        fileMenu = new JMenu("File");
        //Add File to MenuBar
        topMenu.add(fileMenu);

        //Create sub-menu of File - Load
        fileLoadMenu = new JMenu("Load");
        fileMenu.add(fileLoadMenu);

        fileLoadXML = new JMenuItem("XML file...");
        fileLoadMenu.add(fileLoadXML);

        fileLoadSrlz = new JMenuItem("Serialized file...");
        fileLoadMenu.add(fileLoadSrlz);
        fileLoadSrlz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileLoadSrlzActiionPerformed(e);
            }

        });
        //Create sub-menu of File - Save
        fileSaveMenu = new JMenu("Save as");
        //Add sub-menu of File - Save
        fileMenu.add(fileSaveMenu);

        fileSaveXML = new JMenuItem("XML file...");
        fileSaveMenu.add(fileSaveXML);

        fileSaveSrlz = new JMenuItem("Serialized file...");
        fileSaveSrlz.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serializeActionPerformed(evt);
            }
        });
        fileSaveMenu.add(fileSaveSrlz);
        
        helpMenu=new JMenuItem("Help");
        helpMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt){
                showHelp(evt);
            }
        });
        fileMenu.add(helpMenu);

        fileMenu.addSeparator();
        fileExit = new JMenuItem("Exit");
        fileMenu.add(fileExit);

        fileExit.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileExitActionPerformed(evt);
            }
        });
        //</editor-fold>
        allTracks = new TrackList();
        newTracks = new TrackList();

        frame.setLayout(new BorderLayout());

        Color color = frame.getBackground();
        //Создаем новую таблицу на основе двумерного массива данных и заголовков
        TrackListTableModel tltm = new TrackListTableModel(allTracks);
        table = new JTable(tltm);
        //Создаем панель прокрутки и включаем в ее состав нашу таблицу
        JScrollPane jscrlp = new JScrollPane(table);
        //Устаналиваем размеры прокручиваемой области
        table.setPreferredScrollableViewportSize(new Dimension(650, 600));
        //Добавляем в контейнер нашу панель прокрути и таблицу вместе с ней
        frame.getContentPane().add(jscrlp);
        //Отображаем контейнер
        frame.setVisible(true);
        table.setBackground(color);
        JPanel btnPnl = new JPanel(new BorderLayout());
        JPanel bottombtnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton show = new JButton("Show All");
        show.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showBtActionPerformed(evt);
            }
        });
        JButton add = new JButton("Add Track");
        add.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtActionPerformed(evt);
            }
        });
        show.setBackground(Color.white);
        add.setBackground(Color.white);
        bottombtnPnl.add(show);
        bottombtnPnl.add(add);

        btnPnl.add(bottombtnPnl, BorderLayout.CENTER);

        table.getTableHeader().setReorderingAllowed(false);

        frame.add(table.getTableHeader(), BorderLayout.NORTH);
        frame.add(table, BorderLayout.CENTER);
        frame.add(btnPnl, BorderLayout.SOUTH);

        frame.setTitle("Music Library - MusicMetaCollection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        frame.setSize(700, 600);
        frame.setResizable(false);
    }

    private void fileExitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void serializeToFile() {
        if (this.fileChooser.showSaveDialog(this) == 0) {
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(this.fileChooser.getSelectedFile().getAbsoluteFile() + ".bin"));
                out.writeObject(allTracks);
                out.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "File could not be write", "Error", 0);
            }
        }
    }

    private void serializeActionPerformed(java.awt.event.ActionEvent evt) {
        this.serializeToFile();
    }

    private void fileLoadSrlzActiionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
               return file.isDirectory() || file.getAbsolutePath().endsWith(".bin");
            }

            @Override
            public String getDescription() {
                return "Binary files (*.bin)";
            }
        });
        int ret = chooser.showOpenDialog(topMenu);
        if (ret == JFileChooser.APPROVE_OPTION) {
            FileInputStream fis;
            try {
                fis = new FileInputStream(chooser.getSelectedFile().getAbsoluteFile());
                ObjectInputStream ois = new ObjectInputStream(fis);
                allTracks = (TrackList) ois.readObject();
                TrackListTableModel model = new TrackListTableModel(allTracks);
                // и применяем ее к таблице
                table.setModel(model);
                //делаем первую строку выделенной
                if (model.getRowCount() > 0) {
                    table.setRowSelectionInterval(0, 0);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Incorrect file", "Exception", 2);
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
    }

    private void showBtActionPerformed(java.awt.event.ActionEvent evt) {
        //создаем модель на основе полученного треклиста
        TrackListTableModel model = new TrackListTableModel(allTracks);
        // и применяем ее к таблице
        table.setModel(model);
        //делаем первую строку выделенной
        if (model.getRowCount() > 0) {
            table.setRowSelectionInterval(0, 0);
        }
    }

    private void addBtActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            TrackDialog newTrack = new TrackDialog(this, rootPaneCheckingEnabled);
            newTrack.setLocationRelativeTo(this);
            newTrack.setVisible(true);
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
            System.exit(-1);
        }
    }

    public void showNewTrack(TrackInfo track) {
        newTracks.addTrackInfo(track);
        TrackListTableModel model = new TrackListTableModel(newTracks);
        table.setModel(model);
        if (model.getRowCount() > 0) {
            table.setRowSelectionInterval(0, 0);
        }
    }

    public void updateFullTrackList(TrackInfo track) {
        if (track != null) {
            allTracks.addTrackInfo(track);
            track = null;
        }
    }
    
    public void showHelp(java.awt.event.ActionEvent evt){
        try {
            HelpDialog newTrack = new HelpDialog(this, rootPaneCheckingEnabled);
            newTrack.setLocationRelativeTo(this);
            newTrack.setVisible(true);
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
            System.exit(-1);
        }
    }
}
