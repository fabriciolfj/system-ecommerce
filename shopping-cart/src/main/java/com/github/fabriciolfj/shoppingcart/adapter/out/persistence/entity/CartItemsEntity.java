package com.github.fabriciolfj.shoppingcart.adapter.out.persistence.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table("cartitems")
public class CartItemsEntity {

    @Id
    private Long id;
    private Long cartId;
    private String product;
    private BigDecimal price;
    private int amount;
}
