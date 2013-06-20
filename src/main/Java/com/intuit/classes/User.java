package com.intuit.classes;

/**
 * Created with IntelliJ IDEA.
 * User: AUDUPA
 * Date: 12/21/12
 * Time: 12:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class User {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
