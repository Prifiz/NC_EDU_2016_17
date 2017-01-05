package com.nc.o1.musicmetacollection.model;

import java.io.Serializable;

public class Composer implements Author, Serializable {

    private String name;

    /**
     * Constructs a Composer.
     */
    public Composer() {
        name = "";
    }

    /**
     * Constructs a Composer based on the provided composer name.
     *
     * @param name the composer name
     */
    public Composer(String name) {
        this.name = name;
    }

    /**
     * Returns the composer name.
     *
     * @return a composer name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Replaces the composer name with the specified composer name.
     *
     * @param name new composer name
     */
    @Override
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
        if (!name.equals(other.getName())) {
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
        if (!name.isEmpty()) {
            sb.append("\nComposer: ");
            sb.append(name);
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
        result = prime * result + name.hashCode();
        return result;
    }
}
