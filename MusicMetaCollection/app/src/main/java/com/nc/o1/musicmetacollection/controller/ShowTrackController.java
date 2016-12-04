package com.nc.o1.musicmetacollection.controller;

import com.nc.o1.musicmetacollection.model.TrackInfo;

/**
 * Shows info about existing track.
 *
 * @author SteVL
 */
public class ShowTrackController {

    private ShowTrackView view;
    private TrackInfo model;

    public ShowTrackController(TrackInfo model, ShowTrackView view) {
        this.model = model;
        this.view = view;
    }

    public void modelToView() {
        view.setArtist(model.getCommonInfo().getArtist().getName());
        view.setTitle(model.getCommonInfo().getTitle());
        view.setGenre(model.getCommonInfo().getGenre());
        //Converting duration track
        //get from TechnicalInfo getStringLatency()
        int sec = model.getTechnicalInfo().getLatency();
        int min = 0;
        int hour = 0;
        StringBuilder hours = new StringBuilder();
        StringBuilder seconds = new StringBuilder();
        StringBuilder minutes = new StringBuilder();
        //algorithm incorrect
        while (sec > 3600) {
            sec -= 3600;
            hour++;
        }
        while (sec > 60) {
            sec -= 60;
            min++;
        }
        if (sec < 10) {
            seconds.append("0");
        }
        seconds.append(sec);
        if (min < 10) {
            minutes.append("0");
        }
        minutes.append(min);
        if (hour < 10) {
            hours.append("0");
        }
        hours.append(hour);
        //End converting duration track
        view.setLatencyHour(hours.toString());
        view.setLatencyMin(minutes.toString());
        view.setLatencySec(seconds.toString());
        int year = model.getCommonInfo().getYear();
        if (year != 0) {
            view.setYear(String.valueOf(year));
        } else {
            view.setYear("");
        }
        view.setAlbum(model.getCommonInfo().getAlbumInfo().getAlbum());
        view.setCoverPath(model.getCommonInfo().getAlbumInfo().getCover());
        view.setComposer(model.getCommonInfo().getComposer().getName());
        int bpm = model.getTechnicalInfo().getBeatsPerMinute();
        if (bpm != 0) {
            view.setBpm(String.valueOf(bpm));
        } else {
            view.setBpm("");
        }
        view.setKey(model.getTechnicalInfo().getKey());

    }

}
