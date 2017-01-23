package com.nc.o1.musicmetacollection.view;

import com.nc.o1.musicmetacollection.controller.FileSrlzController;
import com.nc.o1.musicmetacollection.view.trackdialog.AddTrackDialog;
import com.nc.o1.musicmetacollection.controller.RemoveTrackController;
import com.nc.o1.musicmetacollection.controller.SearchTrackController;
import com.nc.o1.musicmetacollection.model.TrackInfo;
import com.nc.o1.musicmetacollection.model.TrackList;
import com.nc.o1.musicmetacollection.view.trackdialog.ShowTrackDialog;
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
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
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

public class MainFrame extends JFrame {

    private JMenuBar topMenu;

    private JComboBox<String> searchTrackParam;
    private JRadioButton substringSearchButton;
    private JRadioButton regexpSearchButton;
    private JMenu fileMenu;
    private JMenu fileSaveMenu;
    private JMenu fileLoadMenu;
    private JFileChooser fileChooser;
    Color backgroundColor;
    TrackListTableModel trackListTableModel;
    JScrollPane jscrlp;
    JPanel searchPanel;
    JPanel searchTypePanel;
    JPanel btnPnl;
    JPanel bottombtnPnl;
    JButton showTrackListButton;
    JButton addTrackButton;
    JButton removeTrackButton;
    JButton searchTracksButton;
    JButton clearTableButton;
    ButtonGroup searchRadioButtonsGroup;
    private JMenuItem fileSaveXML;
    private JMenuItem fileSaveSerializable;
    private JMenuItem fileLoadXML;
    private JMenuItem fileLoadSerializable;
    private JMenuItem helpMenu;
    private JMenuItem fileExit;

    private TrackList trackList;
    private TrackList cleanList;
    private Vector searchParamsList;
    private JTable table;
    private JFrame frame;
    private JTextField searchText;

    /**
     * Creates Main Window.
     */
    public MainFrame() {
        initComponents();
    }

    private void initComponents() {
        frame = new JFrame();
        trackList = new TrackList();
        cleanList = new TrackList();
        fileChooser = new JFileChooser();
        searchParamsList = this.getSearchParamsList();
        fileChooser = new JFileChooser();

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

        fileLoadSerializable = new JMenuItem("Serialized file...");
        fileLoadMenu.add(fileLoadSerializable);
        fileLoadSerializable.addActionListener(new ActionListener() {
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

        fileSaveSerializable = new JMenuItem("Serialized file...");
        fileSaveSerializable.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serializeActionPerformed(evt);
            }
        });
        fileSaveMenu.add(fileSaveSerializable);

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
        frame.setLayout(new BorderLayout());

        backgroundColor = frame.getBackground();
        //Создаем новую таблицу на основе двумерного массива данных и заголовков
        trackListTableModel = new TrackListTableModel(trackList);
        table = new JTable(trackListTableModel);
        //Создаем панель прокрутки и включаем её в состав нашей таблицы
        jscrlp = new JScrollPane(table);
        //Устаналиваем размеры прокручиваемой области
        table.setPreferredScrollableViewportSize(new Dimension(650, 600));
        //Добавляем в контейнер нашу панель прокрути и таблицу вместе с ней
        frame.getContentPane().add(jscrlp);
        //Отображаем контейнер
        frame.setVisible(true);
        table.setBackground(backgroundColor);
        searchPanel = new JPanel(new FlowLayout());
        searchTypePanel = new JPanel(new GridBagLayout());
        btnPnl = new JPanel(new BorderLayout());
        bottombtnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));

        searchTrackParam = new JComboBox(searchParamsList);

        showTrackListButton = new JButton("Show All");
        showTrackListButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showBtActionPerformed(evt);
            }
        });
        
        addTrackButton = new JButton("Add Track");
        addTrackButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtActionPerformed(evt);
            }
        });

        removeTrackButton = new JButton("Remove Track");
        removeTrackButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtActionPerformed(evt);
            }
        });

        searchTracksButton = new JButton("Search Track");
        searchTracksButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtActionPerformed(evt);
            }
        });

        clearTableButton = new JButton("Clear Table");
        clearTableButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtActionPerformed(evt);
            }
        });

        searchRadioButtonsGroup = new ButtonGroup();
        substringSearchButton = new JRadioButton("substring", true);
        regexpSearchButton = new JRadioButton("regexp", false);
        searchRadioButtonsGroup.add(substringSearchButton);
        searchRadioButtonsGroup.add(regexpSearchButton);
        searchText = new JTextField(20);
        showTrackListButton.setBackground(Color.white);
        addTrackButton.setBackground(Color.white);
        removeTrackButton.setBackground(Color.white);
        searchTracksButton.setBackground(Color.white);
        clearTableButton.setBackground(Color.white);
        searchPanel.add(new JLabel("Search: "));
        searchPanel.add(searchTrackParam);
        searchPanel.add(searchText);
        searchPanel.add(searchTracksButton);
        searchTypePanel.add(substringSearchButton);
        searchTypePanel.add(regexpSearchButton);
        bottombtnPnl.add(clearTableButton);
        bottombtnPnl.add(showTrackListButton);
        bottombtnPnl.add(addTrackButton);
        bottombtnPnl.add(removeTrackButton);

        btnPnl.add(searchPanel, BorderLayout.NORTH);
        btnPnl.add(searchTypePanel, BorderLayout.CENTER);
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
                showTrackMouseDoubleClick(evt);
            }
        });
    }

    private Vector getSearchParamsList() {
        Vector<String> searchParamsList = new Vector<>();
        searchParamsList.add("Artist");
        searchParamsList.add("Album");
        searchParamsList.add("Title");
        searchParamsList.add("Composer");
        searchParamsList.add("Genre");
        searchParamsList.add("Year");
        searchParamsList.add("BPM");
        searchParamsList.add("Key");
        searchParamsList.add("Comment");
        return searchParamsList;
    }

    private void fileExitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void serializeActionPerformed(java.awt.event.ActionEvent evt) {
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory() || file.getAbsolutePath().endsWith(".bin");
            }

            @Override
            public String getDescription() {
                return "Binary files (*.bin)";
            }
        });
        int ret = fileChooser.showSaveDialog(topMenu);
        if (ret == JFileChooser.APPROVE_OPTION) {
            FileSrlzController fileSrlzCntrl = new FileSrlzController(trackList);
            File file = fileChooser.getSelectedFile().getAbsoluteFile();
            String path = file.getPath();
            if (!path.endsWith(".bin")) {
                file = new File(path + ".bin");
            }
            try {
                fileSrlzCntrl.save(file);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "File could not be write", "Error", 0);
            }
        }
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
            FileSrlzController fileSrlzCntrl = new FileSrlzController();
            try {
                trackList = fileSrlzCntrl.load(chooser.getSelectedFile().getAbsoluteFile());
                showTracks(trackList);
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Incorrect file", "Exception", 2);
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void showTracks(TrackList trackList) {
        TrackListTableModel model = new TrackListTableModel(trackList);
        table.setModel(model);
        if (model.getRowCount() > 0) {
            table.setRowSelectionInterval(0, 0);
        }
    }

    private void clearTable() {
        showTracks(cleanList);
    }

    private void showBtActionPerformed(java.awt.event.ActionEvent evt) {
        showTracks(trackList);
    }

    private void clearBtActionPerformed(java.awt.event.ActionEvent evt) {
        clearTable();
    }

    private void addBtActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            AddTrackDialog newTrack = new AddTrackDialog(this, rootPaneCheckingEnabled);
            newTrack.setLocationRelativeTo(this);
            newTrack.setVisible(true);
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
            System.exit(-1);
        }
    }

    private void searchBtActionPerformed(java.awt.event.ActionEvent evt) {
        SearchTrackController sCtrl = new SearchTrackController(trackList);
        String searchParam = searchTrackParam.getModel().getSelectedItem().toString();
        TrackList schTracks;
        if (substringSearchButton.isSelected()) {
            schTracks = sCtrl.substringSearch(searchParam, searchText.getText());
        } else {
            schTracks = sCtrl.regexpSearch(searchParam, searchText.getText());
        }
        if (!schTracks.isEmpty()) {
            showTracks(schTracks);
        } else {
            clearTable();
            JOptionPane.showMessageDialog(this, "No matches", "Missing Data - MusicMetaCollection", 2);
        }
    }

    private void showTrackMouseDoubleClick(MouseEvent evt) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1 && evt.getClickCount() == 2) {
            TrackListTableModel tModel = (TrackListTableModel) table.getModel();
            TrackInfo selectedTrack = tModel.getTrackInfo(selectedRow);
            try {
                ShowTrackDialog showTrackDialog = new ShowTrackDialog(this, rootPaneCheckingEnabled, selectedTrack);
                showTrackDialog.setVisible(true);
                if (showTrackDialog.isEdited()) {
                    tModel.fireTableDataChanged();
                }
            } catch (ParseException ex) {
                System.err.println("formatter is bad: " + ex.getMessage());
            }
        }
    }

    private void deleteBtActionPerformed(java.awt.event.ActionEvent evt) {
        RemoveTrackController rTrCtrl = new RemoveTrackController();
        trackList = rTrCtrl.removeTrack(trackList, table.getSelectedRow());
        showTracks(trackList);
    }

    public void showNewTrack(TrackInfo track) {
        updateTrackList(track);
        showTracks(trackList);
    }

    private void updateTrackList(TrackInfo track) {
        if (track != null) {
            trackList.addTrackInfo(track);
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
