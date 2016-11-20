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
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 * Describes the window for addition new track.
 *
 * @author Слава
 */
public class TrackDialog extends javax.swing.JDialog {

    private javax.swing.JTextField artist;

    public TrackDialog(java.awt.Frame parent, boolean modal) throws ParseException {
        super(parent, modal);
        this.setTitle("MusicMetaCollection - New track");
        JPanel panel = new JPanel();
        panel.setBackground(Color.lightGray);
        panel.setLayout(null);

        JTextField tf = new JTextField();
        JButton button = new JButton();

//        JLabel lab = new JLabel();

        Font font = new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 25);

        final JTextField artist = jtext();
        artist.setLocation(100, 70);
        JLabel labart = lab();
        labart.setLocation(60, 70);
        labart.setText("Artist");
        panel.add(artist);
        panel.add(labart);

        final JTextField title = jtext();
        title.setLocation(450, 70);
        title.setText("");
        JLabel labtitle = lab();
        labtitle.setLocation(410, 70);
        labtitle.setText("Title");
        panel.add(title);
        panel.add(labtitle);

        final JTextField composer = jtext();
        composer.setLocation(100, 190);
        composer.setText("");
        composer.setVisible(false);
        final JLabel labcomposer = lab();
        labcomposer.setVisible(false);
        labcomposer.setLocation(30, 190);
        labcomposer.setText("Composer");
        panel.add(composer);
        panel.add(labcomposer);

        final JTextField album = jtext();
        album.setLocation(450, 190);
        album.setText("");
        album.setVisible(false);
        final JLabel labalbum = lab();
        labalbum.setVisible(false);
        labalbum.setLocation(410, 190);
        labalbum.setText("Album");
        panel.add(album);
        panel.add(labalbum);

        final JTextField genre = jtext();
        genre.setLocation(100, 250);
        genre.setText("");
        genre.setVisible(false);
        final JLabel labgenre = lab();
        labgenre.setVisible(false);
        labgenre.setLocation(60, 250);
        labgenre.setText("Genre");
        panel.add(genre);
        panel.add(labgenre);

        final JTextField cover = jtext();
        cover.setLocation(450, 250);
        cover.setText("");
        cover.setVisible(false);
        final JLabel labcover = lab();
        labcover.setVisible(false);
        labcover.setLocation(410, 250);
        labcover.setText("Cover");
        panel.add(cover);
        panel.add(labcover);

        final JFormattedTextField year = new JFormattedTextField(new MaskFormatter("####"));
        year.setSize(140, 30);
        year.setLocation(100, 310);
        year.setVisible(false);
        year.setText("");
        final JLabel labyear = lab();
        labyear.setVisible(false);
        labyear.setLocation(60, 310);
        labyear.setText("Year");
        panel.add(year);
        panel.add(labyear);

        final JFormattedTextField bpm = new JFormattedTextField(new MaskFormatter("######"));
        bpm.setSize(140, 30);
        bpm.setLocation(450, 310);
        bpm.setText("");
        bpm.setVisible(false);
        final JLabel labbpm = lab();
        labbpm.setVisible(false);
        labbpm.setLocation(410, 310);
        labbpm.setText("Bpm");
        panel.add(bpm);
        panel.add(labbpm);

        final JFormattedTextField latency = new JFormattedTextField(new SimpleDateFormat("mm:ss"));
        latency.setSize(140, 30);
        latency.setLocation(100, 370);
        latency.setText("");
        latency.setVisible(false);
        final JLabel lablatency = lab();
        lablatency.setVisible(false);
        lablatency.setLocation(40, 370);
        lablatency.setText("Duration");
        panel.add(latency);
        panel.add(lablatency);

        final JTextField key = new JFormattedTextField(new MaskFormatter("?"));
        key.setSize(140, 30);
        key.setLocation(450, 370);
        key.setText("");
        key.setVisible(false);
        final JLabel labkey = lab();
        labkey.setVisible(false);
        labkey.setLocation(410, 370);
        labkey.setText("Key");
        panel.add(key);
        panel.add(labkey);
        
        JButton showAll= new JButton("Advanced");
        showAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                composer.setVisible(true);
                labcomposer.setVisible(true);
                album.setVisible(true);
                labalbum.setVisible(true);
                genre.setVisible(true);
                labgenre.setVisible(true);
                cover.setVisible(true);
                labcover.setVisible(true);
                year.setVisible(true);
                labyear.setVisible(true);
                bpm.setVisible(true);
                labbpm.setVisible(true);
                latency.setVisible(true);
                lablatency.setVisible(true);
                key.setVisible(true);
                labkey.setVisible(true);
            }
        });
        showAll.setBackground(Color.white);
        showAll.setSize(100, 30);
        showAll.setLocation(470, 130);
        panel.add(showAll);

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
