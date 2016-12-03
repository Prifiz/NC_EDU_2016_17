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

    public TrackList substringSearch(TrackList trackList, String searchParam, String searchValue) {
        TrackList searchList = new TrackList();
        TrackInfo currentTrack;
        String searchString;
        switch (searchParam) {
            case "Artist":
                searchString = null;
                break;
            case "Album":
                break;
            case "Title":
                break;
            case "Composer":
                break;
            case "Genre":
                break;
            case "Year":
                break;
            case "BPM":
                break;
            case "Duration":
                break;
            case "Key":
                break;
            case "Comment":
                break;

        }
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

    public TrackList regexpSearch(TrackList trackList, String searchValue, String param) {
        return trackList;
    }
}
