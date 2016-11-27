package com.nc.o1.musicmetacollection.view;

import com.nc.o1.musicmetacollection.controller.AddTrackController;
import com.nc.o1.musicmetacollection.model.AlbumInfo;
import com.nc.o1.musicmetacollection.model.Artist;
import com.nc.o1.musicmetacollection.model.CommonInfo;
import com.nc.o1.musicmetacollection.model.Composer;
import com.nc.o1.musicmetacollection.model.TechnicalInfo;
import com.nc.o1.musicmetacollection.model.TrackInfo;
import static com.nc.o1.musicmetacollection.view.Hello.mainFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 * Describes the window for addition new track.
 *
 * @author Слава
 */
public class TrackDialog extends javax.swing.JDialog {

    private static final String APP_TITLE = "MusicMetaCollection";

    private javax.swing.JTextField artistInput;
    private javax.swing.JTextField titleInput;
    private javax.swing.JTextField genreInput;
    private javax.swing.JTextField composerInput;
    private javax.swing.JTextField albumInput;
    private javax.swing.JTextField coverPathInput;
    //Specific Controls
    private javax.swing.JComboBox yearComboBox;
    private javax.swing.JFormattedTextField bpmInput;
    private javax.swing.JFormattedTextField latencyInputHour;
    private javax.swing.JFormattedTextField latencyInputMin;
    private javax.swing.JFormattedTextField latencyInputSec;
    private javax.swing.JComboBox keyComboBox;

    public String getArtistInput() {
        return artistInput.getText();
    }

    public String getTitleInput() {
        return titleInput.getText();
    }

    public String getGenreInput() {
        return genreInput.getText();
    }

    public String getYearSelected() {
        return (String) yearComboBox.getSelectedItem();
    }

    public String getComposerInput() {
        return composerInput.getText();
    }

    public String getAlbumInput() {
        return albumInput.getText();
    }

    public String getBpm() {
        return bpmInput.getText();
    }

    public String getLatencyInputHour() {
        return latencyInputHour.getText();
    }

    public String getLatencyInputMin() {
        return latencyInputMin.getText();
    }

    public String getLatencyInputSec() {
        return latencyInputSec.getText();
    }

    public String getCoverPath() {
        return coverPathInput.getText();
    }

    public String getKeySelected() {
        return (String) keyComboBox.getSelectedItem();
    }

    public TrackDialog(java.awt.Frame parent, boolean modal) throws ParseException {
        super(parent, modal);
        //if(existTrack==null){
        setTitle("New Track - MusicMetaCollection");
//        else{
//           this.setTitle("Edit Track - MusicMetaCollection"); 
//        }
        JPanel panel = new JPanel();
        panel.setBackground(Color.lightGray);
        panel.setLayout(null);

        artistInput = createTextField();
        artistInput.setLocation(100, 70);
        final JLabel artistLabel = createLabel();
        artistLabel.setLocation(60, 70);
        artistLabel.setText("Artist");
        panel.add(artistInput);
        panel.add(artistLabel);

        titleInput = createTextField();
        titleInput.setLocation(450, 70);
        final JLabel titleLabel = createLabel();
        titleLabel.setLocation(410, 70);
        titleLabel.setText("Title");
        panel.add(titleInput);
        panel.add(titleLabel);

        composerInput = createTextField();
        composerInput.setLocation(100, 190);
        composerInput.setVisible(false);
        final JLabel composerLabel = createLabel();
        composerLabel.setVisible(false);
        composerLabel.setLocation(30, 190);
        composerLabel.setText("Composer");
        panel.add(composerInput);
        panel.add(composerLabel);

        albumInput = createTextField();
        albumInput.setLocation(450, 190);
        albumInput.setVisible(false);
        final JLabel albumLabel = createLabel();
        albumLabel.setVisible(false);
        albumLabel.setLocation(410, 190);
        albumLabel.setText("Album");
        panel.add(albumInput);
        panel.add(albumLabel);

        genreInput = createTextField();
        genreInput.setLocation(100, 250);
        genreInput.setVisible(false);
        final JLabel genreLabel = createLabel();
        genreLabel.setVisible(false);
        genreLabel.setLocation(60, 250);
        genreLabel.setText("Genre");
        panel.add(genreInput);
        panel.add(genreLabel);

        coverPathInput = createTextField();
        coverPathInput.setLocation(450, 250);
        coverPathInput.setVisible(false);
        final JLabel coverPathLabel = createLabel();
        coverPathLabel.setVisible(false);
        coverPathLabel.setLocation(410, 250);
        coverPathLabel.setText("Cover");
        panel.add(coverPathInput);
        panel.add(coverPathLabel);

        Calendar calend = Calendar.getInstance();
        String[] years = new String[calend.get(Calendar.YEAR) - 1899 + 1];
        years[0] = "";
        for (int i = 1; i < years.length; i++) {
            years[i] = "" + (1899 + i);
        }

        yearComboBox = new JComboBox(years);
        yearComboBox.setSize(70, 30);
        yearComboBox.setLocation(100, 310);
        yearComboBox.setVisible(false);
        final JLabel yearLabel = createLabel();
        yearLabel.setVisible(false);
        yearLabel.setLocation(60, 310);
        yearLabel.setText("Year");
        panel.add(yearComboBox);
        panel.add(yearLabel);

        bpmInput = new JFormattedTextField(new MaskFormatter("###"));
        bpmInput.setSize(40, 30);
        bpmInput.setLocation(450, 310);
        bpmInput.setVisible(false);
        final JLabel bpmLabel = createLabel();
        bpmLabel.setVisible(false);
        bpmLabel.setLocation(410, 310);
        bpmLabel.setText("BPM");
        panel.add(bpmInput);
        panel.add(bpmLabel);

        latencyInputHour = new JFormattedTextField(new MaskFormatter("##"));
        latencyInputMin = new JFormattedTextField(new MaskFormatter("##"));
        latencyInputSec = new JFormattedTextField(new MaskFormatter("##"));
        latencyInputHour.setValue("00");
        latencyInputHour.setSize(30, 30);
        latencyInputHour.setLocation(100, 370);
        latencyInputHour.setVisible(false);
        latencyInputMin.setValue("00");
        latencyInputMin.setSize(30, 30);
        latencyInputMin.setLocation(150, 370);
        latencyInputMin.setVisible(false);
        latencyInputSec.setValue("00");
        latencyInputSec.setSize(30, 30);
        latencyInputSec.setLocation(200, 370);
        latencyInputSec.setVisible(false);
        final JLabel latencyLabel = createLabel();
        latencyLabel.setVisible(false);
        latencyLabel.setLocation(40, 370);
        latencyLabel.setText("Duration");
        panel.add(latencyInputHour);
        panel.add(latencyInputMin);
        panel.add(latencyInputSec);
        panel.add(latencyLabel);

        //Should make latin like (C, Cm, C#, C#m)
        String[] keys = {"", "C", "a", "F", "d", "G", "e", "B", "g", "D", "h", "Es", "c", "A",
            "fis", "As", "f", "E", "cis", "Des", "b", "H", "gis", "Ges", "es", "Fis", "dis",
            "Ces", "as", "Cis", "ais"};

        keyComboBox = new JComboBox(keys);
        keyComboBox.setSize(140, 30);
        keyComboBox.setLocation(450, 370);
        keyComboBox.setVisible(false);
        final JLabel keyLabel = createLabel();
        keyLabel.setVisible(false);
        keyLabel.setLocation(410, 370);
        keyLabel.setText("Key");
        panel.add(keyComboBox);
        panel.add(keyLabel);

        JButton showAdvancedBtn = new JButton("Advanced");
        showAdvancedBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                composerInput.setVisible(true);
                composerLabel.setVisible(true);
                albumInput.setVisible(true);
                albumLabel.setVisible(true);
                genreInput.setVisible(true);
                genreLabel.setVisible(true);
                coverPathInput.setVisible(true);
                coverPathLabel.setVisible(true);
                yearComboBox.setVisible(true);
                yearLabel.setVisible(true);
                bpmInput.setVisible(true);
                bpmLabel.setVisible(true);
                latencyInputHour.setVisible(true);
                latencyInputMin.setVisible(true);
                latencyInputSec.setVisible(true);
                latencyLabel.setVisible(true);
                keyComboBox.setVisible(true);
                keyLabel.setVisible(true);
            }
        });
        showAdvancedBtn.setBackground(Color.white);
        showAdvancedBtn.setSize(100, 30);
        showAdvancedBtn.setLocation(470, 130);
        panel.add(showAdvancedBtn);

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

        setContentPane(panel);

        setSize(700, 600);

    }

    private JTextField createTextField() {
        JTextField ftf = new JTextField(10);
        ftf.setSize(140, 30);
        return ftf;
    }

    private JLabel createLabel() {
        JLabel lab = new JLabel("");
        lab.setBackground(Color.white);
        lab.setSize(140, 20);
        return lab;
    }

    private void addTrackActionPerformed(ActionEvent evt) {
        if (artistInput.getText().isEmpty() || titleInput.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Artist or Title are empty.", "Missing Data - " + APP_TITLE, 2);
            return;
        }
        TrackInfo track = new TrackInfo();
        AddTrackController controller = new AddTrackController(track, this);
        controller.addTrack();
       
            mainFrame.updateTrackList(track);
            mainFrame.showNewTrack(track);
        
        mainFrame.setVisible(false);
        mainFrame.setResizable(false);
        dispose();
    }
}
