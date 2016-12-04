/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nc.o1.musicmetacollection.controller;

import com.nc.o1.musicmetacollection.model.TrackList;

/**
 *
 * @author TR1B3N
 */
public class RemoveTrackController {

    public TrackList removeTrack(TrackList trackList, int index) {
        trackList.removeTrackInfo(index);
        return trackList;
    }
}
