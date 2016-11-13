package com.nc.o1.musicmetacollection.model;

public class TrackInfo {

    private CommonInfo commonInfo;
    private TechnicalInfo technicalInfo;

    public TrackInfo() {
        commonInfo = new CommonInfo();
        technicalInfo = new TechnicalInfo();
    }

    public TrackInfo(CommonInfo commonInfo) {
        this.commonInfo = commonInfo;
    }

    public TrackInfo(CommonInfo commonInfo, TechnicalInfo technicalInfo) {
        this.commonInfo = commonInfo;
        this.technicalInfo = technicalInfo;
    }

//    public TrackInfo(Artist artist, String title, int year, int latency) {
//        commonInfo = new CommonInfo(artist, title, year);
//        technicalInfo = new TechnicalInfo(latency);
//    }
//    public TrackInfo(Artist artist, String title, String album, String genre, int year, int latency) {
//        commonInfo = new CommonInfo(artist, title, new AlbumInfo(album), genre, year);
//        technicalInfo = new TechnicalInfo(latency);
//    }
//    public TrackInfo(Artist artist, Composer composer, String title, String album, String genre, String cover, int year, int latency) {
//        commonInfo = new CommonInfo(artist, composer, title, album, genre, cover, year);
//        technicalInfo = new TechnicalInfo(latency);
//    }
//    public TrackInfo(String artist, String composer, String title, String album, String genre, String cover, int year, int bpm, String stringLatency) {
//        commonInfo = new CommonInfo(artist, composer, title, album, genre, cover, year);
//        technicalInfo = new TechnicalInfo(bpm, stringLatency);
//    }
    public CommonInfo getCommonInfo() {
        return commonInfo;
    }

    public TechnicalInfo getTechnicalInfo() {
        return technicalInfo;
    }

    public void setCommonInfo(CommonInfo commonInfo) {
        this.commonInfo = commonInfo;
    }

    public void setTechnicalInfo(TechnicalInfo technicalInfo) {
        this.technicalInfo = technicalInfo;
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
        TrackInfo other = (TrackInfo) obj;
        if (!commonInfo.equals(other.commonInfo)) {
            return false;
        }
        if (!technicalInfo.equals(other.technicalInfo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(commonInfo.toString());
        sb.append(technicalInfo.toString());
        return String.valueOf(sb);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + commonInfo.hashCode();
        result = prime * result + technicalInfo.hashCode();
        return result;
    }
}
