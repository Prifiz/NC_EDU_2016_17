package com.nc.o1.musicmetacollection.model;

import java.io.Serializable;

public class CommonInfo implements Serializable {

    private Artist artist;
    private Composer composer;
    private String title;
    private AlbumInfo albumInfo;
    private String genre;
    private int year;
    private boolean instrumental;

    /**
     * Constructs a CommonInfo.
     */
    public CommonInfo() {
        artist = new Artist();
        composer = new Composer();
        title = "";
        albumInfo = new AlbumInfo();
        genre = "";
        year = 0;
        instrumental = false;
    }

    /**
     * Constructs a CommonInfo based on the provided Artist, track title and
     * type of track.
     *
     * @param artist the Artist
     * @param title the track title
     * @param instrumental the type of the track
     */
    public CommonInfo(Artist artist, String title, boolean instrumental) {
        this();
        this.artist = artist;
        this.title = title;
        this.instrumental = instrumental;
    }

    /**
     * Constructs a CommonInfo based on the provided Artist, track title,
     * AlbumInfo and type of track.
     *
     * @param artist the Artist
     * @param title the track title
     * @param albumInfo the AlbumInfo
     * @param instrumental the type of the track
     */
    public CommonInfo(Artist artist, String title, AlbumInfo albumInfo, boolean instrumental) {
        this();
        this.artist = artist;
        this.title = title;
        this.albumInfo = albumInfo;
        this.instrumental = instrumental;
    }

    /**
     * Constructs a CommonInfo based on the provided Artist, track title, year
     * and type of track.
     *
     * @param artist the Artist
     * @param title the track title
     * @param year the year of the track
     * @param instrumental the type of the track
     */
    public CommonInfo(Artist artist, String title, int year, boolean instrumental) {
        this();
        this.artist = artist;
        this.title = title;
        this.year = year;
        this.instrumental = instrumental;
    }

    /**
     * Constructs a CommonInfo based on the provided Artist, track title,
     * AlbumInfo, genre, year and type of track.
     *
     * @param artist the Artist
     * @param title the track title
     * @param albumInfo the AlbumInfo
     * @param genre the genre of the track
     * @param year the year of the track
     * @param instrumental the type of the track
     */
    public CommonInfo(Artist artist, String title, AlbumInfo albumInfo, String genre, int year, boolean instrumental) {
        this();
        this.artist = artist;
        this.title = title;
        this.albumInfo = albumInfo;
        this.genre = genre;
        this.year = year;
        this.instrumental = instrumental;
    }

    /**
     * Constructs a CommonInfo based on the provided Artist, Composer, track
     * title, AlbumInfo, genre, year and type of track.
     *
     * @param artist the Artist
     * @param composer the Composer
     * @param title the track title
     * @param albumInfo the AlbumInfo
     * @param genre the genre of the track
     * @param year the year of the track
     * @param instrumental the type of the track
     */
    public CommonInfo(Artist artist, Composer composer, String title, AlbumInfo albumInfo, String genre, int year, boolean instrumental) {
        this.artist = artist;
        this.composer = composer;
        this.title = title;
        this.albumInfo = albumInfo;
        this.genre = genre;
        this.year = year;
        this.instrumental = instrumental;
    }

    /**
     * Returns the Artist.
     *
     * @return an Artist
     */
    public Artist getArtist() {
        return artist;
    }

    /**
     * Returns the Composer.
     *
     * @return a Composer
     */
    public Composer getComposer() {
        return composer;
    }

    /**
     * Returns the AlbumInfo.
     *
     * @return an AlbumInfo
     */
    public AlbumInfo getAlbumInfo() {
        return albumInfo;
    }

    /**
     * Returns the track title.
     *
     * @return a track title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the genre of the track.
     *
     * @return a genre of the track
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Returns the year of the track.
     *
     * @return an year of the track
     */
    public int getYear() {
        return year;
    }

    /**
     * Returns the type of the track.
     *
     * @return true if the type of the track is instrumental; false otherwise.
     */
    public boolean isInstrumental() {
        return instrumental;
    }

    /**
     * Replaces the Artist with the specified Artist.
     *
     * @param artist new Artist
     */
    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    /**
     * Replaces the Composer with the specified Composer.
     *
     * @param composer new Composer
     */
    public void setComposer(Composer composer) {
        this.composer = composer;
    }

    /**
     * Replaces the track title with the specified track title.
     *
     * @param title new track title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Replaces the AlbumInfo with the specified AlbumInfo.
     *
     * @param albumInfo new AlbumInfo
     */
    public void setAlbumInfo(AlbumInfo albumInfo) {
        this.albumInfo = albumInfo;
    }

    /**
     * Replaces the genre of the track with the specified genre of the track.
     *
     * @param genre new genre of the track
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Replaces the year of the track with the specified year of the track.
     *
     * @param year new year of the track
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Replaces the type of the track with the specified type of the track.
     *
     * @param instrumental new type of the track
     */
    public void setInstrumental(boolean instrumental) {
        this.instrumental = instrumental;
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
        if(!instrumental == other.instrumental){
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
        sb.append(artist.toString());
        sb.append(albumInfo.toString());
        sb.append("\nTitle: ");
        sb.append(title);
        if (instrumental) {
            sb.append(" (instrumental)");
        }
        if (year != 0) {
            sb.append("\nYear: ");
            sb.append(year);
        }
        if (!genre.isEmpty()) {
            sb.append("\nGenre: ");
            sb.append(genre);
        }
        sb.append(composer.toString());
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
        result = prime * result + artist.hashCode();
        result = prime * result + albumInfo.hashCode();
        result = prime * result + composer.hashCode();
        result = prime * result + genre.hashCode();
        result = prime * result + title.hashCode();
        result = prime * result + year;
        if (instrumental) {
            result++;
        }
        return result;
    }

}
