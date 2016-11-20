package com.nc.o1.musicmetacollection.model;

import java.io.Serializable;

public class TechnicalInfo implements Serializable {

    private int beatsPerMinute;
    private int latency;
    private String key;
    private boolean musicOnly;
    private String comment;

    /**
     * Создание объекта типа TechnicalInfo, содержащего техническую информацию о
     * треке
     */
    public TechnicalInfo() {
        beatsPerMinute = 0;
        latency = 0;
        key = "";
        musicOnly = false;
        comment = "";
    }

    /**
     * Создание объекта типа TechnicalInfo, содержащего техническую информацию о
     * треке
     *
     * @param stringLatency - строковое представление длительности трека в
     * формате "mm:ss"
     * @param musicOnly - true, если трек не содержит слов, и false, если трек
     * со словами
     */
    public TechnicalInfo(String stringLatency, boolean musicOnly) {
        this();
        this.latency = stringToLatency(stringLatency);
        this.musicOnly = musicOnly;
    }

    /**
     * Создание объекта типа TechnicalInfo, содержащего техническую информацию о
     * треке
     *
     * @param beatsPerMinute - количество ударов в минуту
     * @param stringLatency - строковое представление длительности трека в
     * формате "mm:ss"
     * @param key - тональность
     * @param musicOnly - true, если трек не содержит слов, и false, если трек
     * со словами
     */
    public TechnicalInfo(int beatsPerMinute, String stringLatency, String key, boolean musicOnly) {
        this();
        this.beatsPerMinute = beatsPerMinute;
        this.latency = stringToLatency(stringLatency);
        this.key = key;
        this.musicOnly = musicOnly;
    }

    /**
     * Создание объекта типа TechnicalInfo, содержащего техническую информацию о
     * треке
     *
     * @param beatsPerMinute - количество ударов в минуту
     * @param stringLatency - строковое представление длительности трека в
     * формате "mm:ss"
     * @param key - тональность
     * @param musicOnly - true, если трек не содержит слов, и false, если трек
     * со словами
     * @param comment -комментарий
     */
    public TechnicalInfo(int beatsPerMinute, String stringLatency, String key, boolean musicOnly, String comment) {
        this(beatsPerMinute, stringLatency, key, musicOnly);
        this.comment = comment;
    }

    private int stringToLatency(String stringLatency) {
        String[] masLatency = stringLatency.split(":");
        int minutes = Integer.parseInt(masLatency[0]);
        int seconds = Integer.parseInt(masLatency[1]);
        return minutes * 60 + seconds;
    }

    /**
     * Метод получения количества ударов в минуту
     *
     * @return количество ударов в минуту
     */
    public int getBeatsPerMinute() {
        return beatsPerMinute;
    }

    /**
     * Метод получения строкового представления длительности трека в формате
     * "mm:ss"
     *
     * @return строковое представление длительности трека в формате "mm:ss"
     */
    public String getStringLatency() {
        int sec = latency;
        int min = 0;
        StringBuilder seconds = new StringBuilder("");
        StringBuilder minutes = new StringBuilder("");
        while (sec > 60) {
            sec -= 60;
            min++;
        }
        if (sec < 10) {
            seconds.append("0");
        }
        seconds.append(sec);
        if (min < 10) {
            minutes.append("0");
        }
        minutes.append(min);
        minutes.append(":");
        minutes.append(seconds);
        return String.valueOf(minutes);
    }

    /**
     * Метод получения длительности трека в секундах
     *
     * @return длительность трека в секундах
     */
    public int getLatency() {
        return latency;
    }

    /**
     * Метод получения тональности
     *
     * @return тональность
     */
    public String getKey() {
        return key;
    }

    /**
     * Метод проверки наличия слов в треке
     *
     * @return true, если трек не содержит слов, и false, если трек со словами
     */
    public boolean isMusicOnly() {
        return musicOnly;
    }

    /**
     * Метод получения комментария
     *
     * @return комментарий
     */
    public String getComment() {
        return comment;
    }

    /**
     * Метод изменения количества ударов в минуту
     *
     * @param beatsPerMinute - количество ударов в минуту
     */
    public void setBeatsPerMinute(int beatsPerMinute) {
        this.beatsPerMinute = beatsPerMinute;
    }

    /**
     * Метод изменения строкового представления длительности трека в формате
     * "mm:ss"
     *
     * @param stringLatency - строковое представление длительности трека в
     * формате "mm:ss"
     */
    public void setLatency(String stringLatency) {
        latency = stringToLatency(stringLatency);
    }

    /**
     * Метод изменения длительности трека в секундах
     *
     * @param latency - длительность трека в секундах
     */
    public void setLatency(int latency) {
        this.latency = latency;
    }

    /**
     * Метод изменения тональности
     *
     * @param key - тональность
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Метод изменения значения musicOnly
     *
     * @param musicOnly - true, если трек не содержит слов, и false, если трек
     * со словами
     */
    public void setMusicOnly(boolean musicOnly) {
        this.musicOnly = musicOnly;
    }

    /**
     * Метод изменения комментария
     *
     * @param comment - комментарий
     */
    public void setComment(String comment) {
        this.comment = comment;
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
        TechnicalInfo other = (TechnicalInfo) obj;
        if (beatsPerMinute != other.beatsPerMinute) {
            return false;
        }
        if (latency != other.latency) {
            return false;
        }
        if (!key.equals(other.key)) {
            return false;
        }
        if (!musicOnly == other.musicOnly) {
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
        if (latency != 0) {
            sb.append("\nДлительность: ");
            sb.append(this.getStringLatency());
        }
        if (beatsPerMinute != 0) {
            sb.append("\nУдаров в минуту: ");
            sb.append(beatsPerMinute);
        }
        if (!key.isEmpty()) {
            sb.append("\nТональность: ");
            sb.append(key);
        }
        if (musicOnly) {

        }
        if (!comment.isEmpty()) {
            sb.append("\nКомментарий: ");
            sb.append(comment);
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
        result = prime * result + beatsPerMinute;
        result = prime * result + latency;
        result = prime * result + key.hashCode();
        result = prime * result + comment.hashCode();
        return result;
    }
}
