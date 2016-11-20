package com.nc.o1.musicmetacollection.model;

import java.io.Serializable;

public class Artist implements Serializable {

    private String name;

    /**
     * Создание нового исполнителя
     */
    public Artist() {
        name = "";
    }

    /**
     * Создание нового исполнителя
     *
     * @param name - имя исполнителя
     */
    public Artist(String name) {
        this.name = name;
    }

    /**
     * Метод получения имени исполнителя
     *
     * @return имя исполнителя
     */
    public String getName() {
        return name;
    }

    /**
     * Метод изменения имени исполнителя
     *
     * @param name - имя исполнителя
     */
    public void setName(String name) {
        this.name = name;
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
        Artist other = (Artist) obj;
        if (!name.equals(other.name)) {
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
        sb.append("Исполнитель: ");
        sb.append(name);
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
        result = prime * result + name.hashCode();
        return result;
    }
}
