package com.dishant.book.application.model;

public enum Country {

    INDIA("India"), GERMANY("Germany"), NORWAY("Norway");

    private String value;

    Country(String value) {
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