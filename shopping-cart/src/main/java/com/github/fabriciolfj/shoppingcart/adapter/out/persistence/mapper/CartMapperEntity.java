package com.github.fabriciolfj.shoppingcart.adapter.out.persistence.mapper;

import com.github.fabriciolfj.shoppingcart.adapter.out.persistence.entity.CartEntity;
import com.github.fabriciolfj.shoppingcart.adapter.out.persistence.entity.CartItemsEntity;
import com.github.fabriciolfj.shoppingcart.domain.Cart;
import com.github.fabriciolfj.shoppingcart.domain.CartItems;
import org.mapstruct.factory.Mappers;

public class CartMapperEntity {

    private CartMapperEntity() { }

    public static CartEntity toCartEntity(final Cart cart) {
        return CartEntity.builder()
                .code(cart.getCode())
                .customer(cart.getCustomer())
                .status(cart.getStatus().getDescribe())
                .total(cart.getTotal())
                .build();
    }

    public static CartItemsEntity toCartItemsEntity(final CartItems item, final Long cart) {
        return CartItemsEntity.builder()
                .amount(item.getAmount())
                .price(item.getPrice())
                .product(item.getProduct())
                .cartId(cart)
                .build();
    }
}
