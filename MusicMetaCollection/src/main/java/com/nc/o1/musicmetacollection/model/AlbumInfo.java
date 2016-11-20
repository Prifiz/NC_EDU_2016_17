package com.nc.o1.musicmetacollection.model;

import java.io.Serializable;

public class AlbumInfo implements Serializable {

    String album;
    String cover;

    public AlbumInfo() {
        album = "";
        cover = "";
    }

    public AlbumInfo(String album) {
        this();
        this.album = album;
    }

    public AlbumInfo(String album, String cover) {
        this.album = album;
        this.cover = cover;
    }

    public String getAlbum() {
        return album;
    }

    public String getCover() {
        return cover;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!album.isEmpty()) {
            sb.append("\nАльбом: ");
            sb.append(album);
        }
        return String.valueOf(sb);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + album.hashCode();
        result = prime * result + cover.hashCode();
        return result;
    }

}
