package com.nc.o1.musicmetacollection.model;

import java.io.Serializable;

public class TechnicalInfo implements Serializable {

    private int beatsPerMinute;
    private int latency;
    private String key;
    private String comment;

    /**
     * Constructs a TechnicalInfo.
     */
    public TechnicalInfo() {
        beatsPerMinute = 0;
        latency = 0;
        key = "";
        comment = "";
    }

    /**
     * Constructs a TechnicalInfo based on the string representation of the
     * latency of the track.
     *
     * @param stringLatency the string representation of the latency of the
     * track
     */
    public TechnicalInfo(String stringLatency) {
        this();
        this.latency = stringToLatency(stringLatency);
    }

    /**
     * Constructs a TechnicalInfo based on the BPM, string representation of the
     * latency of the track and key.
     *
     * @param beatsPerMinute the BPM
     * @param stringLatency the string representation of the latency of the
     * track
     * @param key the key
     */
    public TechnicalInfo(int beatsPerMinute, String stringLatency, String key) {
        this();
        this.beatsPerMinute = beatsPerMinute;
        this.latency = stringToLatency(stringLatency);
        this.key = key;
    }

    /**
     * Constructs a TechnicalInfo based on the BPM, string representation of the
     * latency of the track, key and comment.
     *
     * @param beatsPerMinute the BPM
     * @param stringLatency the string representation of the latency of the
     * track
     * @param key the key
     * @param comment the comment
     */
    public TechnicalInfo(int beatsPerMinute, String stringLatency, String key, String comment) {
        this(beatsPerMinute, stringLatency, key);
        this.comment = comment;
    }

    private int stringToLatency(String stringLatency) {
        String[] masLatency = stringLatency.split(":");
        int hours = Integer.parseInt(masLatency[0]);
        int minutes = Integer.parseInt(masLatency[1]);
        int seconds = Integer.parseInt(masLatency[2]);
        return hours * 3600 + minutes * 60 + seconds;
    }

    /**
     * Returns the BPM.
     *
     * @return a BPM
     */
    public int getBeatsPerMinute() {
        return beatsPerMinute;
    }

    /**
     * Returns the string representation of the latency of the track.
     *
     * @return a string representation of the latency of the track
     */
    public String getStringLatency() {
        int sec = latency;
        int min = 0;
        int hour = 0;
        StringBuilder hours = new StringBuilder();
        StringBuilder seconds = new StringBuilder();
        StringBuilder minutes = new StringBuilder();
        while (sec > 3600) {
            sec -= 3600;
            hour++;
        }
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
        if (hour < 10) {
            hours.append("0");
        }
        hours.append(hour);
        hours.append(":");
        hours.append(minutes);
        hours.append(":");
        hours.append(seconds);
        return String.valueOf(hours);
    }

    /**
     * Returns the latency of the track.
     *
     * @return a latency of the track
     */
    public int getLatency() {
        return latency;
    }

    /**
     * Returns the key of the track.
     *
     * @return a key of the track
     */
    public String getKey() {
        return key;
    }

    /**
     * Returns the comment.
     *
     * @return a comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Replaces the BPM with the specified BPM.
     *
     * @param beatsPerMinute new BPM
     */
    public void setBeatsPerMinute(int beatsPerMinute) {
        this.beatsPerMinute = beatsPerMinute;
    }

    /**
     * Replaces the latency of the track with the specified string
     * representation of the latency of the track.
     *
     * @param stringLatency a string representation of new latency of the track
     */
    public void setLatency(String stringLatency) {
        latency = stringToLatency(stringLatency);
    }

    /**
     * Replaces the latency with the specified latency.
     *
     * @param latency new latency of the track
     */
    public void setLatency(int latency) {
        this.latency = latency;
    }

    /**
     * Replaces the key with the specified key.
     *
     * @param key new key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Replaces the comment with the specified comment.
     *
     * @param comment new comment
     */
    public void setComment(String comment) {
        this.comment = comment;
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
        if (!comment.isEmpty()) {
            sb.append("\nКомментарий: ");
            sb.append(comment);
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
        result = prime * result + beatsPerMinute;
        result = prime * result + latency;
        result = prime * result + key.hashCode();
        result = prime * result + comment.hashCode();
        return result;
    }
}
