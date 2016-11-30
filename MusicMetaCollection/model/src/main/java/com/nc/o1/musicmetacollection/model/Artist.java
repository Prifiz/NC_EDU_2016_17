package com.nc.o1.musicmetacollection.model;

import java.io.Serializable;

public class Artist implements Serializable {

    private String name;

    /**
     * Constructs an Artist.
     */
    public Artist() {
        name = "";
    }

    /**
     * Constructs an Artist based on the provided artist name.
     *
     * @param name the artist name
     */
    public Artist(String name) {
        this.name = name;
    }

    /**
     * Returns the artist name.
     *
     * @return an artist name
     */
    public String getName() {
        return name;
    }

    /**
     * Replaces the artist name with the specified artist name.
     *
     * @param name new artist name
     */
    public void setName(String name) {
        this.name = name;
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
        Artist other = (Artist) obj;
        if (!name.equals(other.name)) {
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
        sb.append("Artist: ");
        sb.append(name);
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
        result = prime * result + name.hashCode();
        return result;
    }
}
