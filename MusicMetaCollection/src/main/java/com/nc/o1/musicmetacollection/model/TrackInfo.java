package com.nc.o1.musicmetacollection.model;

import java.io.Serializable;

public class TrackInfo implements Serializable {

    private CommonInfo commonInfo;
    private TechnicalInfo technicalInfo;

    /**
     * Constructs a TrackInfo.
     */
    public TrackInfo() {
        commonInfo = new CommonInfo();
        technicalInfo = new TechnicalInfo();
    }

    /**
     * Constructs a TrackInfo based on the provided CommonInfo.
     *
     * @param commonInfo the CommonInfo
     */
    public TrackInfo(CommonInfo commonInfo) {
        this.commonInfo = commonInfo;
    }

    /**
     * Constructs a TrackInfo based on the provided CommonInfo and
     * TechnicalInfo.
     *
     * @param commonInfo the CommonInfo
     * @param technicalInfo the TechnicalInfo
     */
    public TrackInfo(CommonInfo commonInfo, TechnicalInfo technicalInfo) {
        this.commonInfo = commonInfo;
        this.technicalInfo = technicalInfo;
    }

    /**
     * Returns the CommonInfo.
     *
     * @return a CommonInfo
     */
    public CommonInfo getCommonInfo() {
        return commonInfo;
    }

    /**
     * Returns the TechnicalInfo.
     *
     * @return a TechnicalInfo
     */
    public TechnicalInfo getTechnicalInfo() {
        return technicalInfo;
    }

    /**
     * Replaces the CommonInfo with the specified CommonInfo.
     *
     * @param commonInfo new CommonInfo
     */
    public void setCommonInfo(CommonInfo commonInfo) {
        this.commonInfo = commonInfo;
    }

    /**
     * Replaces the TechnicalInfo with the specified TechnicalInfo.
     *
     * @param technicalInfo new TechnicalInfo
     */
    public void setTechnicalInfo(TechnicalInfo technicalInfo) {
        this.technicalInfo = technicalInfo;
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
        TrackInfo other = (TrackInfo) obj;
        if (!commonInfo.equals(other.commonInfo)) {
            return false;
        }
        if (!technicalInfo.equals(other.technicalInfo)) {
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
        sb.append(commonInfo.toString());
        sb.append(technicalInfo.toString());
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
        result = prime * result + commonInfo.hashCode();
        result = prime * result + technicalInfo.hashCode();
        return result;
    }
}
