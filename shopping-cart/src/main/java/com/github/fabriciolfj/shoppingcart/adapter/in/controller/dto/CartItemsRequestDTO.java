package com.github.fabriciolfj.shoppingcart.adapter.in.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartItemsRequestDTO {

    @NotBlank
    private String product;
    @NotNull
    @Positive
    private BigDecimal price;
    @Positive
    private int amount;
}
