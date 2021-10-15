package com.github.fabriciolfj.shoppingcart.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CartItems {

    private String product;
    private BigDecimal price;
    private int amount;
}
