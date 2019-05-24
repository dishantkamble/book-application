package com.dishant.book.application.model;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class LocalPrice extends Entity<UUID> {

    private Country country;

    private BigDecimal price;
}