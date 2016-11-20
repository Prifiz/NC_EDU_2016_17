package com.nc.o1.musicmetacollection.model;

import java.io.Serializable;

public class TrackInfo implements Serializable {

    private CommonInfo commonInfo;
    private TechnicalInfo technicalInfo;

    /**
     * Создание объекта типа TrackInfo, содержащего полную информацию о треке
     */
    public TrackInfo() {
        commonInfo = new CommonInfo();
        technicalInfo = new TechnicalInfo();
    }

    /**
     * Создание объекта типа TrackInfo, содержащего полную информацию о треке
     *
     * @param commonInfo - общая информация о треке
     */
    public TrackInfo(CommonInfo commonInfo) {
        this.commonInfo = commonInfo;
    }

    /**
     * Создание объекта типа TrackInfo, содержащего полную информацию о треке
     *
     * @param commonInfo - общая информация о треке
     * @param technicalInfo - техническая информация о треке
     */
    public TrackInfo(CommonInfo commonInfo, TechnicalInfo technicalInfo) {
        this.commonInfo = commonInfo;
        this.technicalInfo = technicalInfo;
    }

    /**
     * Метод получения общей информации о треке
     *
     * @return общая информация о треке
     */
    public CommonInfo getCommonInfo() {
        return commonInfo;
    }

    /**
     * Метод получения технической информации о треке
     *
     * @return техническая информация о треке
     */
    public TechnicalInfo getTechnicalInfo() {
        return technicalInfo;
    }

    /**
     * Метод изменения общей информации о треке
     *
     * @param commonInfo - общая информация о треке
     */
    public void setCommonInfo(CommonInfo commonInfo) {
        this.commonInfo = commonInfo;
    }

    /**
     * Метод изменения технической информации о треке
     *
     * @param technicalInfo - техническая информация о треке
     */
    public void setTechnicalInfo(TechnicalInfo technicalInfo) {
        this.technicalInfo = technicalInfo;
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
     * Метод получения строкового представления объекта
     *
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(commonInfo.toString());
        sb.append(technicalInfo.toString());
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
        result = prime * result + commonInfo.hashCode();
        result = prime * result + technicalInfo.hashCode();
        return result;
    }
}
