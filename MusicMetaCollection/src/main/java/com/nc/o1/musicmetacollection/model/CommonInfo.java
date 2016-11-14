package com.nc.o1.musicmetacollection.model;

public class CommonInfo {

    private Artist artist;
    private Composer composer;
    private String title;
    private AlbumInfo albumInfo;
    private String genre;
    private int year;

    public CommonInfo() {
        artist = new Artist();
        composer = new Composer();
        title = "";
        albumInfo = new AlbumInfo();
        genre = "";
        year = 0;
    }

    public CommonInfo(Artist artist, String title) {
        this();
        this.artist = artist;
        this.title = title;
    }

    public CommonInfo(Artist artist, String title, AlbumInfo albumInfo) {
        this();
        this.artist = artist;
        this.title = title;
        this.albumInfo = albumInfo;
    }

    public CommonInfo(Artist artist, String title, int year) {
        this();
        this.artist = artist;
        this.title = title;
        this.year = year;
    }

    public CommonInfo(Artist artist, String title, AlbumInfo albumInfo, String genre, int year) {
        this();
        this.artist = artist;
        this.title = title;
        this.albumInfo = albumInfo;
        this.genre = genre;
        this.year = year;
    }

    public CommonInfo(Artist artist, Composer composer, String title, AlbumInfo albumInfo, String genre, int year) {
        this.artist = artist;
        this.composer = composer;
        this.title = title;
        this.albumInfo = albumInfo;
        this.genre = genre;
        this.year = year;
    }

    public Artist getArtist() {
        return artist;
    }

    public Composer getComposer() {
        return composer;
    }

    public AlbumInfo getAlbumInfo() {
        return albumInfo;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setComposer(Composer composer) {
        this.composer = composer;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAlbumInfo(AlbumInfo albumInfo) {
        this.albumInfo = albumInfo;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setYear(int year) {
        this.year = year;
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
        CommonInfo other = (CommonInfo) obj;
        if (!artist.equals(other.artist)) {
            return false;
        }
        if (!title.equals(other.title)) {
            return false;
        }
        if (!albumInfo.equals(other.albumInfo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(artist.toString());
        sb.append(albumInfo.toString());
        sb.append("\nНазвание: ");
        sb.append(title);
        sb.append("\nГод: ");
        sb.append(year);
        sb.append("\nЖанр: ");
        sb.append(genre);
        sb.append(composer.toString());
        return String.valueOf(sb);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + artist.hashCode();
        result = prime * result + albumInfo.hashCode();
        result = prime * result + composer.hashCode();
        result = prime * result + genre.hashCode();
        result = prime * result + title.hashCode();
        result = prime * result + year;
        return result;
    }

}
