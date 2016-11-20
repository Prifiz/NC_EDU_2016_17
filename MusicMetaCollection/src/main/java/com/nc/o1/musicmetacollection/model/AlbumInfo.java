package com.nc.o1.musicmetacollection.model;

import java.io.Serializable;

public class AlbumInfo implements Serializable {

    private String album;
    private String cover;

    /**
     * Создание нового альбома
     */
    public AlbumInfo() {
        album = "";
        cover = "";
    }

    /**
     * Создание нового альбома
     * 
     * @param album - название альбома
     */
    public AlbumInfo(String album) {
        this();
        this.album = album;
    }

    /**
     * Создание нового альбома
     * 
     * @param album - название альбома
     * @param cover - адрес обложки альбома
     */
    public AlbumInfo(String album, String cover) {
        this.album = album;
        this.cover = cover;
    }

    /**
     * Метод получения названия альбома
     * 
     * @return название альбома
     */
    public String getAlbum() {
        return album;
    }

    /**
     * Метод получения адреса обложки альбома
     * 
     * @return адрес обложки альбома
     */
    public String getCover() {
        return cover;
    }

    /**
     * Метод изменения названия альбома
     * 
     * @param album - название альбома
     */
    public void setAlbum(String album) {
        this.album = album;
    }

    /**
     * Метод изменения адреса обложки альбома
     * 
     * @param cover - адрес обложки альбома
     */
    public void setCover(String cover) {
        this.cover = cover;
    }

    /**
     * Метод сравнения объектов
     * 
     * @param obj - объект, с которым происходит сравнение
     * @return true, если объекты одинаковы, и false, если объекты разные
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AlbumInfo other = (AlbumInfo) obj;
        if (!album.equals(other.album)) {
            return false;
        }
        if (!cover.equals(other.cover)) {
            return false;
        }
        return true;
    }

    /**
     * Метод получения строкового представления объекта
     * 
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!album.isEmpty()) {
            sb.append("\nАльбом: ");
            sb.append(album);
        }
        return String.valueOf(sb);
    }

    /**
     * Метод получения хэш-кода объекта
     * 
     * @return хэш-код объекта
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + album.hashCode();
        result = prime * result + cover.hashCode();
        return result;
    }

}
