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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Слава
 */
public class MainFrame extends JFrame {

    TrackInfo track;
    TrackList allTracks;
    String[][] data = new String[20][3];
    JTable table;
    //Массив, содержащий заголовки таблицы
    Object[] headers = {"Исполнитель", "Название", "Альбом"};

    public MainFrame() {
        allTracks = new TrackList();
        JFrame frame = new JFrame();

        frame.setLayout(new BorderLayout());

        Color color = frame.getBackground();
        //Создаем новую таблицу на основе двумерного массива данных и заголовков
        table = new JTable(data, headers);
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
        JButton show = new JButton("Показать");
        show.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showBtActionPerformed(evt);
            }
        });
        JButton add = new JButton("Добавить");
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

        frame.setTitle("ViewAll");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        frame.setSize(700, 600);
        frame.setResizable(false);

    }

    private void showBtActionPerformed(java.awt.event.ActionEvent evt) {
        //создаем модель на основе полученного массива книг
        TrackListTableModel model = new TrackListTableModel(allTracks);
        // и применяем ее к таблице
        table.setModel(model);
        //делаем первую строку выделенной
        if (model.getRowCount() > 0) {
            table.setRowSelectionInterval(0, 0);
        }
    }

    private void addBtActionPerformed(java.awt.event.ActionEvent evt) {
        TrackDialog newTrack = new TrackDialog(this, rootPaneCheckingEnabled);
        newTrack.setLocationRelativeTo(this);
        newTrack.setVisible(true);
    }

    public void updateTrackList(TrackInfo track) {
        if (track != null) {
            allTracks.addTrackInfo(track);
            track = null;
        }
    }

    public TrackInfo getTrack() {
        return track;
    }

    public void setTrack(TrackInfo track) {
        this.track = track;
    }
}
