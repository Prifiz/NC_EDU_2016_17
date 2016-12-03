/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nc.o1.musicmetacollection.controller;

import com.nc.o1.musicmetacollection.model.TrackList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author TR1B3N
 */
public class SearchTrackController {

    public TrackList substringSearch(TrackList trackList, String searchParam, String searchValue) {
        TrackList searchList = new TrackList();
        String trackParam;
        for (int i = 0; i < trackList.getSize(); i++) {
            trackParam = trackParam(i, searchParam, trackList);
            if (trackParam.length() >= searchValue.length()) {
                for (int j = 0; j < trackParam.length() - searchValue.length() + 1; j++) {
                    if (trackParam.toUpperCase().substring(j, searchValue.length() + j).equals(searchValue.toUpperCase())) {
                        searchList.addTrackInfo(trackList.getTrackInfo(i));
                        break;
                    }
                }
            }
        }
        return searchList;
    }

    public TrackList regexpSearch(TrackList trackList, String searchParam, String searchValue) {
        TrackList searchList = new TrackList();
        String trackParam;
        for (int i = 0; i < trackList.getSize(); i++) {
            trackParam = trackParam(i, searchParam, trackList);
            if (regexp(searchValue, trackParam)) {
                searchList.addTrackInfo(trackList.getTrackInfo(i));
                break;
            }
        }
        return searchList;
    }

    private boolean regexp(String searchValue, String trackParam) {
        Pattern p = Pattern.compile(searchValue);
        Matcher m = p.matcher(trackParam);
        return m.matches();
    }

    private String trackParam(int i, String searchParam, TrackList trackList) {
        String trackParam = "";
        switch (searchParam) {
            case "Artist":
                trackParam = trackList.getTrackInfo(i).getCommonInfo().getArtist().getName();
                break;
            case "Album":
                trackParam = trackList.getTrackInfo(i).getCommonInfo().getAlbumInfo().getAlbum();
                break;
            case "Title":
                trackParam = trackList.getTrackInfo(i).getCommonInfo().getTitle();
                break;
            case "Composer":
                trackParam = trackList.getTrackInfo(i).getCommonInfo().getComposer().getName();
                break;
            case "Genre":
                trackParam = trackList.getTrackInfo(i).getCommonInfo().getGenre();
                break;
            case "Year":
                trackParam = String.valueOf(trackList.getTrackInfo(i).getCommonInfo().getYear());
                break;
            case "BPM":
                trackParam = String.valueOf(trackList.getTrackInfo(i).getTechnicalInfo().getBeatsPerMinute());
                break;
            case "Key":
                trackParam = trackList.getTrackInfo(i).getTechnicalInfo().getKey();
                break;
            case "Comment":
                trackParam = trackList.getTrackInfo(i).getTechnicalInfo().getComment();
                break;
        }
        return trackParam;
    }
}
