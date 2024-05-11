package com.fcfm.backend.model;

import jakarta.validation.constraints.NotEmpty;

public class User {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @NotEmpty
    private String username;
    @NotEmpty
    private String pass;
}
