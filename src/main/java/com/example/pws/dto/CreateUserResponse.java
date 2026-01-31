package com.example.pws.dto;

public class CreateUserResponse {

    private long userId ;
    private long userEmail ;

    public long getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(long userEmail) {
        this.userEmail = userEmail;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
