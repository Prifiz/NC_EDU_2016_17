package com.nc.o1.musicmetacollection.view.trackdialog;

import com.nc.o1.musicmetacollection.controller.EditTrackController;
import com.nc.o1.musicmetacollection.controller.ShowTrackView;
import com.nc.o1.musicmetacollection.controller.ShowTrackController;
import com.nc.o1.musicmetacollection.model.TrackInfo;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ShowTrackDialog extends TrackDialog {

    private JButton editBtn;
    private TrackInfo track;

    private boolean editFlag;

    public ShowTrackDialog(Frame parent, boolean modal, TrackInfo existTrack) throws ParseException {
        super(parent, modal);
        setTitle("Track Info - " + APP_TITLE);
        this.track = existTrack;

        ShowTrackView view = new ShowTrackView();
        ShowTrackController showTrackCntrl = new ShowTrackController(track, view);
        showTrackCntrl.modelToView();

        artistInput.setText(view.getArtist());
        titleInput.setText(view.getTitle());
        latencyInputHour.setText(view.getLatencyHour());
        latencyInputMin.setText(view.getLatencyMin());
        latencyInputSec.setText(view.getLatencySec());
        genreInput.setText(view.getGenre());
        yearComboBox.setSelectedItem(view.getYear());
        albumInput.setText(view.getAlbum());
        coverPathInput.setText(view.getCoverPath());
        composerInput.setText(view.getComposer());
        bpmInput.setText(view.getBpm());
        keyComboBox.setSelectedItem(view.getKey());

        artistInput.setEditable(false);
        titleInput.setEditable(false);
        latencyInputHour.setEditable(false);
        latencyInputMin.setEditable(false);
        latencyInputSec.setEditable(false);
        genreInput.setEditable(false);

        yearComboBox.setEditable(false);
        yearComboBox.setEnabled(false);

        albumInput.setEditable(false);
        coverPathInput.setEditable(false);
        composerInput.setEditable(false);
        bpmInput.setEditable(false);

        keyComboBox.setEditable(false);
        keyComboBox.setEnabled(false);

        editBtn = new JButton("Edit");
        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(rootPane, "Not supported yet.");
                editBtnActionPerformed(e);
            }

        });
        editBtn.setSize(100, 30);
        editBtn.setLocation(312, 520);
        panel.add(editBtn);
    }

    private void editBtnActionPerformed(ActionEvent e) {
        setTitle("Edit Track Info - " + APP_TITLE);
        editBtn.setVisible(false);

        artistInput.setEditable(true);
        titleInput.setEditable(true);
        latencyInputHour.setEditable(true);
        latencyInputMin.setEditable(true);
        latencyInputSec.setEditable(true);
        genreInput.setEditable(true);
        
        yearComboBox.setEnabled(true);
        
        albumInput.setEditable(true);
        coverPathInput.setEditable(true);
        composerInput.setEditable(true);
        bpmInput.setEditable(true);

        keyComboBox.setEnabled(true);

        JButton saveBtn = new JButton("Save");
        saveBtn.setSize(100, 30);
        saveBtn.setLocation(312, 520);
        panel.add(saveBtn);
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveActionPerformed(e);
            }
        });
    }

    private void saveActionPerformed(ActionEvent e) {
        ShowTrackView view = new ShowTrackView();
        EditTrackController editCntrl = new EditTrackController(track, view);
        view.setArtist(artistInput.getText());
        view.setTitle(titleInput.getText());
        view.setGenre(genreInput.getText());
        view.setLatencyHour(latencyInputHour.getText());
        view.setLatencyMin(latencyInputMin.getText());
        view.setLatencySec(latencyInputSec.getText());
        view.setYear((String)yearComboBox.getSelectedItem());
        view.setAlbum(albumInput.getText());
        view.setCoverPath(coverPathInput.getText());
        view.setComposer(composerInput.getText());
        view.setBpm(bpmInput.getText());
        view.setKey((String)keyComboBox.getSelectedItem());        
        editCntrl.saveTrack();
        editFlag=true;
        dispose();
    }

    public boolean isEdited() {
        return editFlag;
    }

}
