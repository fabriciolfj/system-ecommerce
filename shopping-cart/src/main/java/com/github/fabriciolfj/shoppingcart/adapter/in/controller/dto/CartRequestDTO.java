package com.github.fabriciolfj.shoppingcart.adapter.in.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartRequestDTO {

    @NotBlank
    private String customer;
    @NotEmpty
    private List<CartItemsRequestDTO> items;
}
