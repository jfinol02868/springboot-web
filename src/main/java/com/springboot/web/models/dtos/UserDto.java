package com.springboot.web.models.dtos;

import com.springboot.web.models.User;

public class UserDto {

    private String tittle;
    private User user;

    public UserDto() {
    }

    public UserDto(String tittle, User user) {
        this.tittle = tittle;
        this.user = user;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
