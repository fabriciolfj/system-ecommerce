package com.github.fabriciolfj.shoppingcart.adatpter.out.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

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
}
