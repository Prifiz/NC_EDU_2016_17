package com.nc.o1.musicmetacollection.view.trackdialog;

import com.nc.o1.musicmetacollection.controller.AddTrackController;
import com.nc.o1.musicmetacollection.model.TrackInfo;
import static com.nc.o1.musicmetacollection.view.Hello.mainFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * Describes the window for addition new track.
 *
 * @author SteVL
 */
public class AddTrackDialog extends TrackDialog {

    public AddTrackDialog(java.awt.Frame parent, boolean modal) throws ParseException {
        super(parent, modal);
        setTitle("New Track - " + APP_TITLE);
        JButton addBtn = new JButton("Add");
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                addTrackActionPerformed(evt);
            }
        }
        );
        addBtn.setBackground(Color.white);
        addBtn.setSize(100, 30);
        addBtn.setLocation(312, 520);
        panel.add(addBtn);
    }

    private void addTrackActionPerformed(ActionEvent evt) {
        if (artistInput.getText().isEmpty() || titleInput.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Artist or Title are empty.", "Missing Data - " + APP_TITLE, 2);
            return;
        }

        AddTrackController addTrCtrl = new AddTrackController();
        TrackInfo track = addTrCtrl.addTrack(getArtistInput(),
                getComposerInput(),
                getTitleInput(),
                getAlbumInput(),
                getCoverPath(),
                getGenreInput(),
                getYearSelected(),
                false,
                getBpm(),
                getLatencyInputHour(),
                getLatencyInputMin(),
                getLatencyInputSec(),
                getKeySelected(),
                "");
        dispose();
        mainFrame.showNewTrack(track);
    }
}
