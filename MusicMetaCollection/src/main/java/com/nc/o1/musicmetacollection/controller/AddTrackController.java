package com.nc.o1.musicmetacollection.controller;

import com.nc.o1.musicmetacollection.model.Artist;
import com.nc.o1.musicmetacollection.model.CommonInfo;
import com.nc.o1.musicmetacollection.model.TrackInfo;
import com.nc.o1.musicmetacollection.view.TrackDialog;

/**
 *
 * @author SteVL
 */
public class AddTrackController {

    private TrackInfo model;
    private TrackDialog view;

    public AddTrackController(TrackInfo model, TrackDialog view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Adds new track.
     */
    public void addTrack() {
        String artist = view.getArtistInput().getText();
        String title = view.getTitleInput().getText();
        CommonInfo commonInfo = new CommonInfo(new Artist(artist), title);
        model.setCommonInfo(commonInfo);
    }

    //Service temp method
    public void printModel() {
        System.out.println(model.getCommonInfo());
    }

}
