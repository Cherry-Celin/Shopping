package com.example.shop.entity;

import lombok.Getter;

import java.util.Date;
@Getter
public class Comment {
    private int id;
    private int buyer_id;
    private int seller_id;
    private String content;
    private Date comment_date;

    private String buyernickname;
    private String buyeravater;
    private String buyerlocation;



    public Comment() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBuyer_id(int buyer_id) {
        this.buyer_id = buyer_id;
    }

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setComment_date(Date comment_date) {
        this.comment_date = comment_date;
    }

    public void setBuyernickname(String buyernickname) {
        this.buyernickname = buyernickname;
    }

    public void setBuyeravater(String buyeravater) {
        this.buyeravater = buyeravater;
    }

    public void setBuyerlocation(String buyerlocation) {
        this.buyerlocation = buyerlocation;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", buyer_id=" + buyer_id +
                ", seller_id=" + seller_id +
                ", content='" + content + '\'' +
                ", comment_date=" + comment_date +
                ", buyeravater=" + buyerlocation +
                '}';
    }
}
