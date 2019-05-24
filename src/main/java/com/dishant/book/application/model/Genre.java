package com.dishant.book.application.model;

public enum Genre {

    HORROR("Horror"), ROMANTIC("Romantic"), SCI_FI("Sci-Fi"), THRILLER("Thriller"), BIOGRAPHY("Biography");

    private String value;

    Genre(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}