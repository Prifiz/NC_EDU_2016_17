/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nc.o1.musicmetacollection.controller;

import com.nc.o1.musicmetacollection.model.TrackList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author TR1B3N
 */
public class SearchTrackController {

    Map<Integer, Map<String, String>> trackMap = new HashMap();
    TrackList trackList;

    public SearchTrackController(TrackList trackList) {
        this.trackList = trackList;
        this.createMapOfTrackList(trackList);
    }

    private void createMapOfTrackList(TrackList trackList) {
        for (int i = 0; i < trackList.size(); i++) {
            Map<String, String> map = new HashMap();
            map.put("Artist", trackList.getTrackInfo(i).getCommonInfo().getArtist().getName());
            map.put("Album", trackList.getTrackInfo(i).getCommonInfo().getAlbumInfo().getAlbum());
            map.put("Title", trackList.getTrackInfo(i).getCommonInfo().getTitle());
            map.put("Composer", trackList.getTrackInfo(i).getCommonInfo().getComposer().getName());
            map.put("Genre", trackList.getTrackInfo(i).getCommonInfo().getGenre());
            map.put("Year", String.valueOf(trackList.getTrackInfo(i).getCommonInfo().getYear()));
            map.put("BPM", String.valueOf(trackList.getTrackInfo(i).getTechnicalInfo().getBeatsPerMinute()));
            map.put("Key", trackList.getTrackInfo(i).getTechnicalInfo().getKey());
            map.put("Comment", trackList.getTrackInfo(i).getTechnicalInfo().getComment());
            trackMap.put(i, map);
        }
    }

    public TrackList substringSearch(String searchParam, String searchValue) {
        TrackList searchList = new TrackList();
        String trackParam;
        for (int i = 0; i < trackList.size(); i++) {
            trackParam = trackMap.get(i).get(searchParam);
            if (trackParam.length() >= searchValue.length()) {
                if (trackParam.toUpperCase().contains(searchValue.toUpperCase())) {
                    searchList.addTrackInfo(trackList.getTrackInfo(i));
                }
            }
        }
        return searchList;
    }

    public TrackList regexpSearch(String searchParam, String searchValue) {
        TrackList searchList = new TrackList();
        String trackParam;
        for (int i = 0; i < trackList.size(); i++) {
            trackParam = trackMap.get(i).get(searchParam);
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
}
