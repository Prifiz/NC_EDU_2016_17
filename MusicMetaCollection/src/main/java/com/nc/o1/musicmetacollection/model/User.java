package com.nc.o1.musicmetacollection.model;

/**
 * Describes User entity
 *
 * @author SteVL
 */
public class User {

    /**
     * How to call user
     */
    private String username;
    /**
     * login & id
     */
    private String email;
    private String password;

    /**
     * Creates new user
     *
     * @param username
     * @param email
     * @param password
     * @param group
     */
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    /**
     * Creates existing user
     *
     * @param email
     */
    public User(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //for DataBase
    public void createUser(User user) {
        System.out.println("createUser isn't supported yet.");
    }

    public void readUser(String email, String password) {
        System.out.println("readUser isn't supported yet.");
    }

    public void updateUser(User user) {
        System.out.println("updateUser isn't supported yet.");
    }

    public void deleteUser(User user) {
        System.out.println("deleteUser isn't supported yet.");
    }

    @Override
    public String toString() {
        StringBuilder sbl = new StringBuilder();
        sbl.append(username).append(" ").append(email);
        return sbl.toString();
    }

    //need to test
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        User other = (User) object;
        if (!this.username.equalsIgnoreCase(other.username)) {
            return false;
        }

        if (!this.email.equalsIgnoreCase(other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 37;
        hash = hash * 4 + this.username.hashCode();
        hash = hash * 4 + this.email.hashCode();
        hash = hash * 4 + this.password.hashCode();
        return hash;
    }

}
