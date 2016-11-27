package com.nc.o1.musicmetacollection.controller;

import com.nc.o1.musicmetacollection.model.*;
import com.nc.o1.musicmetacollection.view.TrackDialog;

/**
 *
 * @author SteVL
 */
public class AddTrackController {

    private TrackInfo model;
    private TrackDialog view;

    /**
     * Creates controller for addition new track.
     *
     * @param model - track's information.
     * @param view - data from TrackDialog.
     */
    public AddTrackController(TrackInfo model, TrackDialog view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Adds new track.
     */
    public void addTrack() {
        String artist = view.getArtistInput();
        String title = view.getTitleInput();
        String genre = view.getGenreInput();
        int year = 0;
        if (!view.getYearSelected().isEmpty()) {
            year = Integer.parseInt(view.getYearSelected());
        }

        /* Duration track*/
        String hh = view.getLatencyInputHour();
        String mm = view.getLatencyInputMin();
        String ss = view.getLatencyInputSec();
        StringBuilder sbl = new StringBuilder();
        sbl.append(hh).append(":").append(mm).append(":").append(ss);
        String duration = sbl.toString();
        /*Duration track*/

        String album = view.getAlbumInput();
        String coverPath = view.getCoverPath();
        String composer = view.getComposerInput();
        int bpm = 0;
        if (!view.getBpm().startsWith(" ")) {
            bpm = Integer.parseInt(view.getBpm());
        }
        String key = view.getKeySelected();
        String comment = "";

        model.setCommonInfo(new CommonInfo(new Artist(artist),
                new Composer(composer), title, new AlbumInfo(album, coverPath),
                genre, year, false));
        model.setTechnicalInfo(new TechnicalInfo(bpm, duration, key, comment));
    }    
    //Service temp method
    public void printModel() {
        System.out.println(model);
    }

}
