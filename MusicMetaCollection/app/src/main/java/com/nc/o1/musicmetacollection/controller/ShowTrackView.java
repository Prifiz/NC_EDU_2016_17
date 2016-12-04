package com.nc.o1.musicmetacollection.controller;

/**
 * Layer between ShowTrackDialog and ShowTrackController.
 *
 * @author SteVL
 */
public class ShowTrackView {
    private String artist;
    private String title;
    private String latencyHour, latencyMin, latencySec;
    private String genre;
    private String year;
    private String album;
    private String coverPath;
    private String composer;
    private String bpm;
    private String key;

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public String getLatencyHour() {
        return latencyHour;
    }

    public String getLatencyMin() {
        return latencyMin;
    }

    public String getLatencySec() {
        return latencySec;
    }

    public String getGenre() {
        return genre;
    }

    public String getYear() {
        return year;
    }

    public String getAlbum() {
        return album;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public String getComposer() {
        return composer;
    }

    public String getBpm() {
        return bpm;
    }

    public String getKey() {
        return key;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLatencyHour(String latencyHour) {
        this.latencyHour = latencyHour;
    }

    public void setLatencyMin(String latencyMin) {
        this.latencyMin = latencyMin;
    }

    public void setLatencySec(String latencySec) {
        this.latencySec = latencySec;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public void setBpm(String bpm) {
        this.bpm = bpm;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
