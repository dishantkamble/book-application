package com.dishant.book.application.model;

public abstract class Entity<I> {

    protected I id;

    public I getId() {
        return this.id;
    }

    public void setId(I id) {
        this.id = id;
    }
}
