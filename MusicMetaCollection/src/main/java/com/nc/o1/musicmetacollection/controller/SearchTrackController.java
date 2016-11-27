/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nc.o1.musicmetacollection.controller;

import com.nc.o1.musicmetacollection.model.TrackInfo;
import com.nc.o1.musicmetacollection.model.TrackList;

/**
 *
 * @author TR1B3N
 */
public class SearchTrackController {

    public SearchTrackController() {
    }

    public TrackList searchTracks(TrackList trackList, String searchValue) {
        TrackList searchList = new TrackList();
        TrackInfo currentTrack;
        for (int i = 0; i < trackList.getSize(); i++) {
            currentTrack = trackList.getTrackInfo(i);
            for (int j = 0; j < currentTrack.toString().length() - searchValue.length() + 1; j++) {
                if (currentTrack.toString().substring(j, searchValue.length() + j).equals(searchValue)) {
                    searchList.addTrackInfo(currentTrack);
                }
            }
        }
        return searchList;
    }
}
