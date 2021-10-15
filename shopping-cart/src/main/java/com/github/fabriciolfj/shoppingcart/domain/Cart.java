package com.github.fabriciolfj.shoppingcart.domain;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cart {

    private String customer;
    @EqualsAndHashCode.Include
    private String code;
    private BigDecimal total;
    private Status status = Status.PENDING;
}
