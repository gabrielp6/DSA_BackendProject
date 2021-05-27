package edu.upc.dsa.models;

import java.util.List;

public class Credentials {

    String username;
    String password;


    public Credentials() {
    }


    public Credentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}