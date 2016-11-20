package com.nc.o1.musicmetacollection.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TrackList implements Serializable {

    private List<TrackInfo> tracks;

    /**
     * Создание нового треклиста
     */
    public TrackList() {
        tracks = new ArrayList<TrackInfo>();
    }

    /**
     * Метод добавления трека в треклист
     *
     * @param trackInfo - трек
     */
    public void addTrackInfo(TrackInfo trackInfo) {
        tracks.add(trackInfo);
    }

    /**
     * Метод получения трека по номеру в треклисте
     *
     * @param index - номер трека в треклисте
     * @return трек по номеру в треклисте
     */
    public TrackInfo getTrackInfo(int index) {
        return tracks.get(index);
    }

    /**
     * Метод изменения трека по номеру в треклисте и ссылке на новый трек
     *
     * @param index - номер трека в треклисте
     * @param trackInfo - трек
     */
    public void setTrackInfo(int index, TrackInfo trackInfo) {
        tracks.set(index, trackInfo);
    }

    /**
     * Метод удаления трека из треклиста по номеру
     *
     * @param index - номер трека в треклисте
     */
    public void removeTrackInfo(int index) {
        tracks.remove(index);
    }

    /**
     * Метод получения размера треклиста
     *
     * @return размер треклиста
     */
    public int getSize() {
        return tracks.size();
    }

}
