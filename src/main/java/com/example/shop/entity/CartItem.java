package com.example.shop.entity;

import lombok.Getter;

@Getter
public class CartItem {

    private int id;
    private User user;
    private Product product;

    public CartItem() {
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

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", user=" + user +
                ", product=" + product +
                '}';
    }
}
