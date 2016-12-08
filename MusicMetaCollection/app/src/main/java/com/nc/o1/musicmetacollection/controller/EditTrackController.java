package com.nc.o1.musicmetacollection.controller;

import com.nc.o1.musicmetacollection.model.AlbumInfo;
import com.nc.o1.musicmetacollection.model.Artist;
import com.nc.o1.musicmetacollection.model.Composer;
import com.nc.o1.musicmetacollection.model.TrackInfo;

/**
 *
 * @author SteVL
 */
public class EditTrackController {

    private ShowTrackView view;
    private TrackInfo model;

    public EditTrackController(TrackInfo model, ShowTrackView view) {
        this.model = model;
        this.view = view;
    }

    public void saveTrack() {
        Artist artist = new Artist(view.getArtist());
        model.getCommonInfo().setArtist(artist);
        model.getCommonInfo().setTitle(view.getTitle());
        model.getCommonInfo().setGenre(view.getGenre());
        int year = 0;
        String yearStr = view.getYear();
        if (!yearStr.equals("")) {
            year = Integer.parseInt(yearStr);
        }
        model.getCommonInfo().setYear(year);
        AlbumInfo albumInfo = new AlbumInfo(view.getAlbum(), view.getCoverPath());
        model.getCommonInfo().setAlbumInfo(albumInfo);
        Composer composer = new Composer(view.getComposer());
        model.getCommonInfo().setComposer(composer);
        int bpm = 0;
        String bpmStr = view.getBpm();
        if (!bpmStr.equals("") && !bpmStr.startsWith(" ")) {
            bpm = Integer.parseInt(bpmStr);
        }
        model.getTechnicalInfo().setBeatsPerMinute(bpm);
        //Coverting duration
        int ss = 0;
        String sec = view.getLatencySec();
        if (!sec.equals("")) {
            ss = Integer.parseInt(sec);
        }
        int mm = 0;
        String min = view.getLatencyMin();
        if (!min.equals("")) {
            mm = Integer.parseInt(min);
        }
        int hh = 0;
        String hour = view.getLatencyHour();
        System.out.println("'" + hour + "'");
        if (!hour.equals("")) {
            hh = Integer.parseInt(hour);
        }
        //end converting duration
        model.getTechnicalInfo().setLatency(hh * 3600 + mm * 60 + ss);
        model.getTechnicalInfo().setKey(view.getKey());
    }

}
