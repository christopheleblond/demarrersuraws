package com.github.christopheleblond.backend.model;

import java.util.UUID;

public class Registration {

    private String username;

    private String uuid;

    public Registration(String username) {
        this.username = username;
        this.uuid = UUID.randomUUID().toString();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
