package com.nc.o1.musicmetacollection.model;

public class User {

    private String username;
    private String email;
    private String password;

    /**
     * Constructs new User based on the provided username, email address and
     * password.
     *
     * @param username name
     * @param email email address
     * @param password password
     */
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    /**
     * Constructs new User based on the provided email address.
     *
     * @param email email address
     */
    public User(String email) {
        this.email = email;
    }

    /**
     * Returns the username.
     *
     * @return an username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns the email address.
     *
     * @return an email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the password.
     *
     * @return a password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Replaces the username with the specified username.
     *
     * @param username new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Replaces the email address with the specified email address.
     *
     * @param email new email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Replaces the password with the specified password.
     *
     * @param password new password
     */
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

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        StringBuilder sbl = new StringBuilder();
        sbl.append(username).append(" ").append(email);
        return sbl.toString();
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
        User other = (User) obj;
        if (!this.username.equalsIgnoreCase(other.username)) {
            return false;
        }

        if (!this.email.equalsIgnoreCase(other.email)) {
            return false;
        }
        return true;
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        int hash = 37;
        hash = hash * 4 + this.username.hashCode();
        hash = hash * 4 + this.email.hashCode();
        hash = hash * 4 + this.password.hashCode();
        return hash;
    }

}
