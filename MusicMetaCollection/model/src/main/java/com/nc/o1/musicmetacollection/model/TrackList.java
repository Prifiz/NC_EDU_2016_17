package com.nc.o1.musicmetacollection.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TrackList implements Serializable {

    private List<TrackInfo> trackList;

    /**
     * Constructs an empty TrackList.
     */
    public TrackList() {
        trackList = new ArrayList<TrackInfo>();
    }

    /**
     * Appends the specified TrackInfo to the end of this TrackList.
     *
     * @param trackInfo TrackInfo to be appended to this TrackList
     */
    public void addTrackInfo(TrackInfo trackInfo) {
        trackList.add(trackInfo);
    }

    /**
     * Returns the TrackInfo at the specified position in this TrackList.
     *
     * @param index index of the TrackInfo to return
     * @return the TrackInfo at the specified position in this TrackList
     */
    public TrackInfo getTrackInfo(int index) {
        return trackList.get(index);
    }

    /**
     * Replaces the TrackInfo at the specified position in this TrackList with
     * the specified TrackInfo.
     *
     * @param index index of the TrackInfo to replace
     * @param trackInfo TrackInfo to be stored at the specified position
     */
    public void setTrackInfo(int index, TrackInfo trackInfo) {
        trackList.set(index, trackInfo);
    }

    /**
     * Removes the TrackInfo at the specified position in this TrackList. Shifts
     * any subsequent TracksInfo to the left (subtracts one from their indices).
     *
     * @param index index of the TrackInfo to be removed
     */
    public void removeTrackInfo(int index) {
        trackList.remove(index);
    }

    /**
     * Returns the number of TracksInfo in this TrackList.
     *
     * @return the number of TracksInfo in this TrackList
     */
    public int size() {
        return trackList.size();
    }

    /**
     * Returns true if this TrackList contains no TrackInfo.
     *
     * @return true if this TrackList contains no TrackInfo
     */
    public boolean isEmpty() {
        return trackList.isEmpty();
    }

    /**
     * Returns true if this TrackList contains the specified TrackInfo.
     *
     * @param trackInfo TrackInfo whose presence in this list is to be tested
     * @return true if this TrackList contains the specified TrackInfo
     */
    public boolean containsTrackInfo(TrackInfo trackInfo) {
        return trackList.contains(trackInfo);
    }

}
