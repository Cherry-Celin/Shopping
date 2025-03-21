package com.example.shop.entity;

import lombok.Getter;

import java.util.Date;

@Getter
public class User {
    private Integer id;
    private String username;//登录用户名
    private String password;//登录密码
    private String nickname;//昵称
    private String avatar;//头像
    private String email;
    private Date create_time;
    private Date update_time;
    private Date birthday;
    private String sexy;
    private String location;
    private String detail_address;
    private Double phone_number;
    private Double property;



    public User() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setSexy(String sexy) {
        this.sexy = sexy;
    }


    public void setPhone_number(Double phone_number) {
        this.phone_number = phone_number;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDetail_address(String detail_address) {
        this.detail_address = detail_address;
    }

    public void setProperty(Double property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
