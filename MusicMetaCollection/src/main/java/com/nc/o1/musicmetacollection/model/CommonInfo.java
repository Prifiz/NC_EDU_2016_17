package com.nc.o1.musicmetacollection.model;

import java.io.Serializable;

public class CommonInfo implements Serializable {

    private Artist artist;
    private Composer composer;
    private String title;
    private AlbumInfo albumInfo;
    private String genre;
    private int year;

    /**
     * Создание объекта типа CommonInfo, содержащего общую информацию о треке
     */
    public CommonInfo() {
        artist = new Artist();
        composer = new Composer();
        title = "";
        albumInfo = new AlbumInfo();
        genre = "";
        year = 0;
    }

    /**
     * Создание объекта типа CommonInfo, содержащего общую информацию о треке
     *
     * @param artist - исполнитель
     * @param title - название трека
     */
    public CommonInfo(Artist artist, String title) {
        this();
        this.artist = artist;
        this.title = title;
    }

    /**
     * Создание объекта типа CommonInfo, содержащего общую информацию о треке
     *
     * @param artist - исполнитель
     * @param title - название трека
     * @param albumInfo - альбом
     */
    public CommonInfo(Artist artist, String title, AlbumInfo albumInfo) {
        this();
        this.artist = artist;
        this.title = title;
        this.albumInfo = albumInfo;
    }

    /**
     * Создание объекта типа CommonInfo, содержащего общую информацию о треке
     *
     * @param artist - исполнитель
     * @param title - название трека
     * @param year - год издания
     */
    public CommonInfo(Artist artist, String title, int year) {
        this();
        this.artist = artist;
        this.title = title;
        this.year = year;
    }

    /**
     * Создание объекта типа CommonInfo, содержащего общую информацию о треке
     *
     * @param artist - исполнитель
     * @param title - название трека
     * @param albumInfo - альбом
     * @param genre - жанр
     * @param year - год издания
     */
    public CommonInfo(Artist artist, String title, AlbumInfo albumInfo, String genre, int year) {
        this();
        this.artist = artist;
        this.title = title;
        this.albumInfo = albumInfo;
        this.genre = genre;
        this.year = year;
    }

    /**
     * Создание объекта типа CommonInfo, содержащего общую информацию о треке
     *
     * @param artist - исполнитель
     * @param composer - композитор
     * @param title - название альбома
     * @param albumInfo - альбом
     * @param genre - жанр
     * @param year - год издания
     */
    public CommonInfo(Artist artist, Composer composer, String title, AlbumInfo albumInfo, String genre, int year) {
        this.artist = artist;
        this.composer = composer;
        this.title = title;
        this.albumInfo = albumInfo;
        this.genre = genre;
        this.year = year;
    }

    /**
     * Метод получения исполнителя
     *
     * @return исполнитель
     */
    public Artist getArtist() {
        return artist;
    }

    /**
     * Метод получения композитора
     *
     * @return композитор
     */
    public Composer getComposer() {
        return composer;
    }

    /**
     * Метод получения альбома
     *
     * @return альбом
     */
    public AlbumInfo getAlbumInfo() {
        return albumInfo;
    }

    /**
     * Метод получения названия трека
     *
     * @return название трека
     */
    public String getTitle() {
        return title;
    }

    /**
     * Метод получения жанра
     *
     * @return жанр
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Метод получения года издания
     *
     * @return год издания
     */
    public int getYear() {
        return year;
    }

    /**
     * Метод изменения исполнителя
     *
     * @param artist - исполнитель
     */
    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    /**
     * Метод изменения композитора
     *
     * @param composer - композитор
     */
    public void setComposer(Composer composer) {
        this.composer = composer;
    }

    /**
     * Метод изменения названия трека
     *
     * @param title - название трека
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Метод изменения альбома
     *
     * @param albumInfo - альбом
     */
    public void setAlbumInfo(AlbumInfo albumInfo) {
        this.albumInfo = albumInfo;
    }

    /**
     * Метод изменения жанра
     *
     * @param genre - жанр
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Метод изменения года издания
     *
     * @param year - год издания
     */
    public void setYear(int year) {
        this.year = year;
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

    /**
     * Метод получения строкового представления объекта
     *
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(artist.toString());
        sb.append(albumInfo.toString());
        sb.append("\nНазвание: ");
        sb.append(title);
        if (year != 0) {
            sb.append("\nГод: ");
            sb.append(year);
        }
        if (!genre.isEmpty()) {
            sb.append("\nЖанр: ");
            sb.append(genre);
        }
        sb.append(composer.toString());
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
        result = prime * result + artist.hashCode();
        result = prime * result + albumInfo.hashCode();
        result = prime * result + composer.hashCode();
        result = prime * result + genre.hashCode();
        result = prime * result + title.hashCode();
        result = prime * result + year;
        return result;
    }

}
