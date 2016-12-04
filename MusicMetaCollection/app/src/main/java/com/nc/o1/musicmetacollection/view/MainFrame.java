/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nc.o1.musicmetacollection.view;

import com.nc.o1.musicmetacollection.controller.RemoveTrackController;
import com.nc.o1.musicmetacollection.controller.SearchTrackController;
import com.nc.o1.musicmetacollection.model.TrackInfo;
import com.nc.o1.musicmetacollection.model.TrackList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Слава
 */
public class MainFrame extends JFrame {

    private final JMenuBar topMenu;

    private javax.swing.JComboBox<String> searchTrackParam;
    private JRadioButton searchBt, regexpBt;
    private final JMenu fileMenu, fileSaveMenu, fileLoadMenu;
    private JFileChooser fileChooser = new JFileChooser();
    private final JMenuItem fileSaveXML, fileSaveSrlz;
    private final JMenuItem fileLoadXML, fileLoadSrlz;
    private final JMenuItem helpMenu;
    private final JMenuItem fileExit;

    TrackList allTracks;
    //  String[][] data = new String[20][2];
    JTable table;
    //Массив, содержащий заголовки таблицы
    //  Object[] headers = {"Artist", "Title"};
    JFrame frame;
    JTextField searchText;

    /**
     * Creates Main Window.
     */
    public MainFrame() {
        frame = new JFrame();
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

        helpMenu = new JMenuItem("Help");
        helpMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
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
        JPanel searchPanel = new JPanel(new FlowLayout());
        JPanel radioPanel = new JPanel(new GridBagLayout());
        JPanel btnPnl = new JPanel(new BorderLayout());
        JPanel bottombtnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        String[] searchParams = {"Artist", "Album", "Title", "Composer", "Genre", "Year", "BPM", "Key", "Comment"};
        searchTrackParam = new JComboBox(searchParams);

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

        JButton del = new JButton("Delete Track");
        del.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtActionPerformed(evt);
            }
        });

        JButton search = new JButton("Search Track");
        search.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtActionPerformed(evt);
            }
        });

        JButton clear = new JButton("Clear Table");
        clear.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtActionPerformed(evt);
            }
        });

        ButtonGroup group = new ButtonGroup();
        searchBt = new JRadioButton("substring", true);
        regexpBt = new JRadioButton("regexp", false);
        group.add(searchBt);
        group.add(regexpBt);
        searchText = new JTextField(20);
        show.setBackground(Color.white);
        add.setBackground(Color.white);
        del.setBackground(Color.white);
        search.setBackground(Color.white);
        clear.setBackground(Color.white);
        searchPanel.add(new JLabel("Search: "));
        searchPanel.add(searchTrackParam);
        searchPanel.add(searchText);
        searchPanel.add(search);
        radioPanel.add(searchBt);
        radioPanel.add(regexpBt);
        bottombtnPnl.add(clear);
        bottombtnPnl.add(show);
        bottombtnPnl.add(add);
        bottombtnPnl.add(del);

        btnPnl.add(searchPanel, BorderLayout.NORTH);
        btnPnl.add(radioPanel, BorderLayout.CENTER);
        btnPnl.add(bottombtnPnl, BorderLayout.SOUTH);

        table.getTableHeader().setReorderingAllowed(false);

        frame.add(table.getTableHeader(), BorderLayout.NORTH);
        frame.add(table, BorderLayout.CENTER);
        frame.add(btnPnl, BorderLayout.SOUTH);

        frame.setTitle("Music Library - MusicMetaCollection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        frame.setSize(700, 600);
        frame.setResizable(false);

        frame.setVisible(true);
        frame.setSize(700, 600);
        frame.setResizable(false);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                editTrackMouseDoubleClick(evt);
            }
        });
    }

    private void fileExitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void serializeToFile() {
        if (this.fileChooser.showSaveDialog(this) == 0) {
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(this.fileChooser.getSelectedFile().getAbsoluteFile()));
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
                showTracks(allTracks);
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

    private void showTracks(TrackList trackList) {
        //создаем модель на основе полученного треклиста
        TrackListTableModel model = new TrackListTableModel(trackList);
        // и применяем ее к таблице
        table.setModel(model);
        //делаем первую строку выделенной
        if (model.getRowCount() > 0) {
            table.setRowSelectionInterval(0, 0);
        }
    }

    private void clearTable() {
        showTracks(new TrackList());
    }

    private void showBtActionPerformed(java.awt.event.ActionEvent evt) {
        showTracks(allTracks);
    }

    private void clearBtActionPerformed(java.awt.event.ActionEvent evt) {
        clearTable();
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

    private void searchBtActionPerformed(java.awt.event.ActionEvent evt) {
        SearchTrackController sCtrl = new SearchTrackController();
        String searchParam = searchTrackParam.getModel().getSelectedItem().toString();
        TrackList schTracks;
        if (searchBt.isSelected()) {
            schTracks = sCtrl.substringSearch(allTracks, searchParam, searchText.getText());
        } else {
            schTracks = sCtrl.regexpSearch(allTracks, searchParam, searchText.getText());
        }
        if (schTracks.getSize() != 0) {
            showTracks(schTracks);
        } else {
            clearTable();
            JOptionPane.showMessageDialog(this, "No matches", "Missing Data - MusicMetaCollection", 2);
        }
    }

    private void editTrackMouseDoubleClick(MouseEvent evt) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1 && evt.getClickCount() == 2) {
            TrackListTableModel tModel = (TrackListTableModel) table.getModel();
            //TrackDialog editTrack= new TrackDialog(this, rootPaneCheckingEnabled);
            JOptionPane.showMessageDialog(rootPane, "Test");
        }
    }

    private void deleteBtActionPerformed(java.awt.event.ActionEvent evt) {
        RemoveTrackController rTrCtrl = new RemoveTrackController();
        allTracks = rTrCtrl.removeTrack(allTracks, table.getSelectedRow());
        showTracks(allTracks);
//        TrackListTableModel tltm = (TrackListTableModel) table.getModel();
//        tltm.removeRow(table.getSelectedRow());
//        table.setModel(tltm);
    }

    public void showNewTrack(TrackInfo track) {
        updateTrackList(track);
        showTracks(allTracks);
    }

    private void updateTrackList(TrackInfo track) {
        if (track != null) {
            allTracks.addTrackInfo(track);
            track = null;
        }
    }

    public void showHelp(java.awt.event.ActionEvent evt) {
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
