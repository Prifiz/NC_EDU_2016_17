package com.nc.o1.musicmetacollection.controller;

import com.nc.o1.musicmetacollection.model.*;

/**
 *
 * @author TR1B3N
 */
public class SearchTrackController {

    public TrackList searchTracks(TrackList trackList, String searchValue) {
        TrackList searchList = new TrackList();
        TrackInfo currentTrack;
        for (int i = 0; i < trackList.getSize(); i++) {
            currentTrack = trackList.getTrackInfo(i);
            for (int j = 0; j < currentTrack.toString().length() - searchValue.length() + 1; j++) {
                if (currentTrack.toString().toUpperCase().substring(j, searchValue.length() + j).equals(searchValue.toUpperCase())) {
                    searchList.addTrackInfo(currentTrack);
                    break;
                }
            }
        }
        return searchList;
    }
}
