package com.dishant.book.application.model;

import java.time.Year;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class Book extends Entity<UUID> {

    private String title;

    private Author author;

    private Genre genre;

    private Year publishedOn;

    private LocalPrice price;

    private Long pages;
}