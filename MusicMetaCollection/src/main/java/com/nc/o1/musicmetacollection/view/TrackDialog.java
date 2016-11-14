/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nc.o1.musicmetacollection.view;

import com.nc.o1.musicmetacollection.model.AlbumInfo;
import com.nc.o1.musicmetacollection.model.Artist;
import com.nc.o1.musicmetacollection.model.CommonInfo;
import com.nc.o1.musicmetacollection.model.Composer;
import com.nc.o1.musicmetacollection.model.TechnicalInfo;
import com.nc.o1.musicmetacollection.model.TrackInfo;
import static com.nc.o1.musicmetacollection.view.Swing.mainFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Слава
 */
public class TrackDialog extends JFrame {

    private javax.swing.JTextField artist;

    TrackDialog() {

        super("AddTrack");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setBackground(Color.lightGray);
        panel.setLayout(null);

        JTextField tf = new JTextField();
        JButton button = new JButton();

        JLabel lab = new JLabel();

        Font font = new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 25);

        final JTextField artist = jtext();
        artist.setLocation(312, 130);
        lab = lab();
        lab.setLocation(260, 130);
        lab.setText("Артист");
        panel.add(artist);
        panel.add(lab);

        final JTextField title = jtext();
        title.setLocation(312, 160);
        title.setText("");
        lab = lab();
        lab.setLocation(246, 160);
        lab.setText("Название");
        panel.add(title);
        panel.add(lab);

        final JTextField composer = jtext();
        composer.setLocation(312, 190);
        composer.setText("");
        lab = lab();
        lab.setLocation(234, 190);
        lab.setText("Композитор");
        panel.add(composer);
        panel.add(lab);

        final JTextField album = jtext();
        album.setLocation(312, 220);
        album.setText("");
        lab = lab();
        lab.setLocation(258, 220);
        lab.setText("Альбом");
        panel.add(album);
        panel.add(lab);

        final JTextField genre = jtext();
        genre.setLocation(312, 250);
        genre.setText("");
        lab = lab();
        lab.setLocation(270, 250);
        lab.setText("Жанр");
        panel.add(genre);
        panel.add(lab);

        final JTextField cover = jtext();
        cover.setLocation(312, 280);
        cover.setText("");
        lab = lab();
        lab.setLocation(250, 280);
        lab.setText("Обложка");
        panel.add(cover);
        panel.add(lab);

        final JTextField year = jtext();
        year.setLocation(312, 310);
        year.setText("");
        lab = lab();
        lab.setLocation(280, 310);
        lab.setText("Год");
        panel.add(year);
        panel.add(lab);

        final JTextField bpm = jtext();
        bpm.setLocation(312, 340);
        bpm.setText("");
        lab = lab();
        lab.setLocation(280, 340);
        lab.setText("Bpm");
        panel.add(bpm);
        panel.add(lab);

        final JTextField latency = jtext();
        latency.setLocation(312, 370);
        latency.setText("");
        lab = lab();
        lab.setLocation(184, 370);
        lab.setText("Продолжительность");
        panel.add(latency);
        panel.add(lab);

        final JTextField key = jtext();
        key.setLocation(312, 400);
        key.setText("");
        lab = lab();
        lab.setLocation(229, 400);
        lab.setText("Тональность");
        panel.add(key);
        panel.add(lab);

        JButton add =  new JButton("Добавить");
        add.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                TrackInfo track = null;
                if (!artist.getText().isEmpty() && !title.getText().isEmpty()) {

                    if (!album.getText().isEmpty() && !genre.getText().isEmpty() && !year.getText().isEmpty()) {

                        if (!cover.getText().isEmpty() && !latency.getText().isEmpty()) {

                            if (!composer.getText().isEmpty() && !bpm.getText().isEmpty() && !key.getText().isEmpty()) {
                                track = new TrackInfo(
                                        new CommonInfo(
                                                new Artist(artist.getText()),
                                                new Composer(composer.getText()),
                                                title.getText(),
                                                new AlbumInfo(album.getText(), cover.getText()),
                                                genre.getText(),
                                                Integer.parseInt(year.getText())),
                                        new TechnicalInfo(
                                                Integer.parseInt(bpm.getText()),
                                                latency.getText(),
                                                key.getText(), false));
                            } else {
                                track = new TrackInfo(
                                        new CommonInfo(
                                                new Artist(artist.getText()),
                                                title.getText(),
                                                new AlbumInfo(album.getText(), cover.getText()),
                                                genre.getText(),
                                                Integer.parseInt(year.getText())),
                                        new TechnicalInfo(
                                                latency.getText(), false));
                            }
                        } else {
                            track = new TrackInfo(
                                    new CommonInfo(
                                            new Artist(artist.getText()),
                                            title.getText(),
                                            new AlbumInfo(album.getText()),
                                            genre.getText(),
                                            Integer.parseInt(year.getText())),
                                    new TechnicalInfo());
                        }
                    } else {
                        track = new TrackInfo(
                                new CommonInfo(
                                        new Artist(artist.getText()),
                                        title.getText()),
                                new TechnicalInfo());
                    }
                }

                mainFrame.setTrack(track);
                System.out.println(track.toString());
                System.out.println(mainFrame.getTrack().toString());
                mainFrame.setVisible(false);
                mainFrame.setResizable(false);
                dispose();
            }
        }
        );

        add.setBackground(Color.white);

        add.setSize(100, 30);
        add.setLocation(312, 520);
        panel.add(add);

        setContentPane(panel);

        setSize(700, 600);

    }

    JTextField jtext() {

        JTextField ftf = new JTextField(10);
        ftf.setSize(140, 20);
        return ftf;

    }

    JLabel lab() {
        JLabel lab = new JLabel("");
        lab.setBackground(Color.white);
        lab.setSize(140, 20);
        return lab;

    }

    private void showBtActionPerformed(java.awt.event.ActionEvent evt) {
        
    }
    
}
