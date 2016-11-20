package com.nc.o1.musicmetacollection.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TrackList implements Serializable {

    private List<TrackInfo> tracks;

    public TrackList() {
        tracks = new ArrayList<TrackInfo>();
    }

    public void addTrackInfo(TrackInfo trackInfo) {
        tracks.add(trackInfo);
    }

    public void addTrackInfo(int index, TrackInfo trackInfo) {
        tracks.add(index, trackInfo);
    }

    public TrackInfo getTrackInfo(int index) {
        return tracks.get(index);
    }

    public void setTrackInfo(int index, TrackInfo trackInfo) {
        tracks.set(index, trackInfo);
    }

    public void removeTrackInfo(int index) {
        tracks.remove(index);
    }

    public int getSize() {
        return tracks.size();
    }

}
