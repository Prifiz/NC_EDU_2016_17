package com.nc.o1.musicmetacollection.model;

import java.io.Serializable;

public class Composer implements Serializable {

    private String name;

    /**
     * Создание нового композитора
     */
    public Composer() {
        name = "";
    }

    /**
     * Создание нового композитора
     *
     * @param name - имя композитора
     */
    public Composer(String name) {
        this.name = name;
    }

    /**
     * Метод получения имени композитора
     *
     * @return имя композитора
     */
    public String getName() {
        return name;
    }

    /**
     * Метод изменения имени композитора
     *
     * @param name - имя композитора
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
        if (!name.equals(other.getName())) {
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
        if (!name.isEmpty()) {
            sb.append("\nКомпозитор: ");
            sb.append(name);
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
        result = prime * result + name.hashCode();
        return result;
    }
}
