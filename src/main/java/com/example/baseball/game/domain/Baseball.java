package com.example.baseball.game.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Baseball {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private int tryCount = 0;

    private boolean success = false;

    public Baseball() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void increaseTryCount() {
        this.tryCount++;
    }

    public boolean isSuccess() {
        return success;
    }

    public void success() {
        this.success = true;
    }

}
