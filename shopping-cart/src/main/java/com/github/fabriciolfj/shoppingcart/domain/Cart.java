package com.github.fabriciolfj.shoppingcart.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

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
    private Status status;
    private List<CartItems> items;

    public Cart enrichmentInit() {
        this.code = UUID.randomUUID().toString();
        this.total = items.stream().map(p -> p.getPrice().multiply(BigDecimal.valueOf(p.getAmount())))
                .reduce((x, y) -> x.add(y))
                .get();
        this.status = Status.PENDING;
        return this;
    }
}
