package com.DreamShop.hp.DreamShop.models;

import java.util.ArrayList;
import java.util.List;

public class ProductModel {
    private String title;
    private String[] imageUrl;
    private String videoUrl;
    private Enum<Category> category;
    private int rating;
    private String price;
    private String description;
    private boolean isLike;
    private boolean isToBasket;


    public ProductModel(String title, String[] imageUrl, String videoUrl, Enum<Category> category, int rating, String price, String description, boolean isLike, boolean isToBasket) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.videoUrl = videoUrl;
        this.category = category;
        this.rating = rating;
        this.price = price;
        this.description = description;
        this.isLike = isLike;
        this.isToBasket = isToBasket;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String[] imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Enum<Category> getCategory() {
        return category;
    }

    public void setCategory(Enum<Category> category) {
        this.category = category;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    public boolean isToBasket() {
        return isToBasket;
    }

    public void setToBasket(boolean toBasket) {
        isToBasket = toBasket;
    }
}
