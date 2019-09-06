package com.dishant.book.application.model;

import java.time.Year;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class Author extends Entity<UUID> {

    private String name;

    private Country country;

    private Year activeFrom;

    private Year activeTo;
}