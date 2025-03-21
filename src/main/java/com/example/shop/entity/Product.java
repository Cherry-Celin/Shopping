package com.example.shop.entity;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Product {

    private int id;
    private String product_name;
    private Double price;
    private String description;
    private LocalDateTime create_time;
    private LocalDateTime update_time;
    private String img_url;
    private Boolean is_deleted;
    private String status;
    private LocalDateTime publish_start;
    private LocalDateTime publish_end;
    private int type_id;
    private User user;
    private String ways;
    private Double postage;
    private Double donation_percent;


    public Product() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }



    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreate_time(LocalDateTime create_time) {
        this.create_time = create_time;
    }

    public void setUpdate_time(LocalDateTime update_time) {
        this.update_time = update_time;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public void setIs_deleted(Boolean is_deleted) {
        this.is_deleted = is_deleted;
    }


    public void setPublish_start(LocalDateTime publish_start) {
        this.publish_start = publish_start;
    }

    public void setPublish_end(LocalDateTime publish_end) {
        this.publish_end = publish_end;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setWays(String ways) {
        this.ways = ways;
    }

    public void setPostage(Double postage) {
        this.postage = postage;
    }

    public void setDonation_percent(Double donation_percent) {
        this.donation_percent = donation_percent;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", product_name='" + product_name + '\'' +
                ", price=" + price +
                ", img_url='" + img_url + '\'' +
                ", is_deleted=" + is_deleted +
                ", status=" + status +
                ", postage=" + postage +
                '}';
    }
}
