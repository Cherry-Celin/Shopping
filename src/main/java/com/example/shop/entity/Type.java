package com.example.shop.entity;

import lombok.Getter;

import java.util.List;

@Getter
public class Type {

    private int id;
    private String name;
    private List<Product> products;

    public Type() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
