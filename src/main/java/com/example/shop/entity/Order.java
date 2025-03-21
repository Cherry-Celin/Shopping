package com.example.shop.entity;

import lombok.Getter;

import java.util.Date;

@Getter
public class Order {

    private int id;
    private User user;
    private int seller_id;
    private Product product;
    private Comment comment;
    private Date create_time;
    private Date update_time;
    private Boolean is_deleted;

    public Order() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }



    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public void setIs_deleted(Boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }



    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", product=" + product +
                ", comment=" + comment +
                ", create_time=" + create_time +
                '}';
    }
}
