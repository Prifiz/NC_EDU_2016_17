package com.nc.o1.musicmetacollection.model;

import java.io.Serializable;

public class TechnicalInfo implements Serializable {

    private int beatsPerMinute;
    private int latency;
    private String key;
    private boolean musicOnly;
    private String comment;

    public TechnicalInfo() {
        beatsPerMinute = 0;
        latency = 0;
        key = "";
        musicOnly = false;
        comment = "";
    }

    public TechnicalInfo(String stringLatency, boolean musicOnly) {
        this();
        this.latency = stringToLatency(stringLatency);
        this.musicOnly = musicOnly;
    }

    public TechnicalInfo(int beatsPerMinute, String stringLatency, String key, boolean musicOnly) {
        this();
        this.beatsPerMinute = beatsPerMinute;
        this.latency = stringToLatency(stringLatency);
        this.key = key;
        this.musicOnly = musicOnly;
    }

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

    public int getBeatsPerMinute() {
        return beatsPerMinute;
    }

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

    public int getLatency() {
        return latency;
    }

    public String getKey() {
        return key;
    }

    public boolean isMusicOnly() {
        return musicOnly;
    }

    public String getComment() {
        return comment;
    }

    public void setBeatsPerMinute(int beatsPerMinute) {
        this.beatsPerMinute = beatsPerMinute;
    }

    public void setLatency(String stringLatency) {
        latency = stringToLatency(stringLatency);
    }

    public void setLatency(int latency) {
        this.latency = latency;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setMusicOnly(boolean musicOnly) {
        this.musicOnly = musicOnly;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nДлительность: ");
        sb.append(this.getStringLatency());
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
