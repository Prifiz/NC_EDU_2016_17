package com.nc.o1.musicmetacollection.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TrackList implements Serializable {

    private List<TrackInfo> tracks;

    /**
     * Constructs an empty TrackList.
     */
    public TrackList() {
        tracks = new ArrayList<TrackInfo>();
    }

    /**
     * Appends the specified TrackInfo to the end of this TrackList.
     *
     * @param trackInfo TrackInfo to be appended to this TrackList
     */
    public void addTrackInfo(TrackInfo trackInfo) {
        tracks.add(trackInfo);
    }

    /**
     * Returns the TrackInfo at the specified position in this TrackList.
     *
     * @param index index of the TrackInfo to return
     * @return the TrackInfo at the specified position in this TrackList
     */
    public TrackInfo getTrackInfo(int index) {
        return tracks.get(index);
    }

    /**
     * Replaces the TrackInfo at the specified position in this TrackList with
     * the specified TrackInfo.
     *
     * @param index index of the TrackInfo to replace
     * @param trackInfo TrackInfo to be stored at the specified position
     */
    public void setTrackInfo(int index, TrackInfo trackInfo) {
        tracks.set(index, trackInfo);
    }

    /**
     * Removes the TrackInfo at the specified position in this TrackList. Shifts
     * any subsequent TracksInfo to the left (subtracts one from their indices).
     *
     * @param index index of the TrackInfo to be removed
     */
    public void removeTrackInfo(int index) {
        tracks.remove(index);
    }

    /**
     * Returns the number of TracksInfo in this TrackList.
     *
     * @return the number of TracksInfo in this TrackList
     */
    public int getSize() {
        return tracks.size();
    }

}
