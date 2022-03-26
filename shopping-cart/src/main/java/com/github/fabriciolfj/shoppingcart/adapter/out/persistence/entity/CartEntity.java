package com.github.fabriciolfj.shoppingcart.adapter.out.persistence.entity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Builder
@Table("cart")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class CartEntity {

    @Id
    @EqualsAndHashCode.Include
    private Long id;
    private String customer;
    private String code;
    private BigDecimal total;
    private String status;
}
