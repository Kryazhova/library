package com.example.library.model;

import com.example.library.entity.User;

import java.io.Serializable;

public class UserSaveResponse implements Serializable {

    private User user;
    private long id;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserSaveResponse{" +
                "user=" + user +
                ", id=" + id +
                '}';
    }
}
