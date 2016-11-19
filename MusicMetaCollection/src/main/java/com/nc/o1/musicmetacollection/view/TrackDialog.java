package com.nc.o1.musicmetacollection.view;

import com.nc.o1.musicmetacollection.model.AlbumInfo;
import com.nc.o1.musicmetacollection.model.Artist;
import com.nc.o1.musicmetacollection.model.CommonInfo;
import com.nc.o1.musicmetacollection.model.Composer;
import com.nc.o1.musicmetacollection.model.TechnicalInfo;
import com.nc.o1.musicmetacollection.model.TrackInfo;
import static com.nc.o1.musicmetacollection.view.Hello.mainFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Describes the window for addition new track.
 *
 * @author Слава
 */
public class TrackDialog extends javax.swing.JDialog {

    private javax.swing.JTextField artist;

    public TrackDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setTitle("MusicMetaCollection - New track");
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
        lab.setLocation(264, 130);
        lab.setText("Artist");
        panel.add(artist);
        panel.add(lab);

        final JTextField title = jtext();
        title.setLocation(312, 160);
        title.setText("");
        lab = lab();
        lab.setLocation(246, 160);
        lab.setText("Title");
        panel.add(title);
        panel.add(lab);

        final JTextField composer = jtext();
        composer.setLocation(312, 190);
        composer.setText("");
        lab = lab();
        lab.setLocation(234, 190);
        lab.setText("Composer");
        panel.add(composer);
        panel.add(lab);

        final JTextField album = jtext();
        album.setLocation(312, 220);
        album.setText("");
        lab = lab();
        lab.setLocation(258, 220);
        lab.setText("Album");
        panel.add(album);
        panel.add(lab);

        final JTextField genre = jtext();
        genre.setLocation(312, 250);
        genre.setText("");
        lab = lab();
        lab.setLocation(270, 250);
        lab.setText("Genre");
        panel.add(genre);
        panel.add(lab);

        final JTextField cover = jtext();
        cover.setLocation(312, 280);
        cover.setText("");
        lab = lab();
        lab.setLocation(250, 280);
        lab.setText("Cover");
        panel.add(cover);
        panel.add(lab);

        final JTextField year = jtext();
        year.setLocation(312, 310);
        year.setText("");
        lab = lab();
        lab.setLocation(280, 310);
        lab.setText("Year");
        panel.add(year);
        panel.add(lab);

        final JTextField bpm = jtext();
        bpm.setLocation(312, 340);
        bpm.setText("");
        lab = lab();
        lab.setLocation(277, 340);
        lab.setText("Bpm");
        panel.add(bpm);
        panel.add(lab);

        final JTextField latency = jtext();
        latency.setLocation(312, 370);
        latency.setText("");
        lab = lab();
        lab.setLocation(184, 370);
        lab.setText("Duration");
        panel.add(latency);
        panel.add(lab);

        final JTextField key = jtext();
        key.setLocation(312, 400);
        key.setText("");
        lab = lab();
        lab.setLocation(229, 400);
        lab.setText("Key");
        panel.add(key);
        panel.add(lab);

        JButton add = new JButton("Add");
        add.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                TrackInfo track = null;
                if (!artist.getText().isEmpty() && !title.getText().isEmpty() && !album.getText().isEmpty()) {

                    if (!genre.getText().isEmpty() && !year.getText().isEmpty()) {

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
                                        title.getText(),
                                        new AlbumInfo(album.getText())),
                                new TechnicalInfo());
                    }
                }

                mainFrame.updateTrackList(track);
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
        ftf.setSize(140, 30);
        return ftf;

    }

    JLabel lab() {
        JLabel lab = new JLabel("");
        lab.setBackground(Color.white);
        lab.setSize(140, 20);
        return lab;
    }

}
