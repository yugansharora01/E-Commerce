package com.yash.marketplace.models;

import java.sql.Timestamp;

public class Item {
    String id;
    String name;
    String description;
    Double price;
    String imgUrl;
    Integer quantity;
    Timestamp boughtOn;
    Timestamp listedOn;
    Timestamp createdOn;

    public Item(String id, String name, String description, Double price, String imgUrl, Integer quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
        this.quantity = quantity;

        this.createdOn = new Timestamp(System.currentTimeMillis());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Timestamp getBoughtOn() {
        return boughtOn;
    }

    public void setBoughtOn(Timestamp boughtOn) {
        this.boughtOn = boughtOn;
    }

    public Timestamp getListedOn() {
        return listedOn;
    }

    public void setListedOn(Timestamp listedOn) {
        this.listedOn = listedOn;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imgUrl='" + imgUrl + '\'' +
                ", quantity=" + quantity +
                ", boughtOn=" + boughtOn +
                ", listedOn=" + listedOn +
                ", createdOn=" + createdOn +
                '}';
    }
}
