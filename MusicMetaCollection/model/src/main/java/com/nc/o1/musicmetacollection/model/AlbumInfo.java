package com.nc.o1.musicmetacollection.model;

import java.io.Serializable;

public class AlbumInfo implements Serializable {

    private String album;
    private String cover;

    /**
     * Constructs an AlbumInfo.
     */
    public AlbumInfo() {
        album = "";
        cover = "";
    }

    /**
     * Constructs an AlbumInfo based on the provided album name.
     *
     * @param album the album name
     */
    public AlbumInfo(String album) {
        this();
        this.album = album;
    }

    /**
     * Constructs an AlbumInfo based on the provided album name and the path to
     * the cover.
     *
     * @param album the album name
     * @param cover the path to the cover
     */
    public AlbumInfo(String album, String cover) {
        this.album = album;
        this.cover = cover;
    }

    /**
     * Returns the album name.
     *
     * @return an album name
     */
    public String getAlbum() {
        return album;
    }

    /**
     * Returns the path to the cover.
     *
     * @return a path to the cover
     */
    public String getCover() {
        return cover;
    }

    /**
     * Replaces the album name in this AlbumInfo with the specified album name.
     *
     * @param album new album name
     */
    public void setAlbum(String album) {
        this.album = album;
    }

    /**
     * Replaces the path to the cover in this AlbumInfo with the specified path
     * to the cover.
     *
     * @param cover new path to the cover
     */
    public void setCover(String cover) {
        this.cover = cover;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param obj the reference object with which to compare.
     * @return true if this object is the same as the obj argument; false
     * otherwise.
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
     * Returns a string representation of the object.
     *
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!album.isEmpty()) {
            sb.append("\nAlbum: ");
            sb.append(album);
        }
        return String.valueOf(sb);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object
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
