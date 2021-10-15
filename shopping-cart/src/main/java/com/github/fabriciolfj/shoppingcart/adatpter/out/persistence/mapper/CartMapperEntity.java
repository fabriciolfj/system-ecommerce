package com.github.fabriciolfj.shoppingcart.adatpter.out.persistence.mapper;

import com.github.fabriciolfj.shoppingcart.adatpter.out.persistence.entity.CartEntity;
import com.github.fabriciolfj.shoppingcart.adatpter.out.persistence.entity.CartItemsEntity;
import com.github.fabriciolfj.shoppingcart.domain.Cart;
import com.github.fabriciolfj.shoppingcart.domain.CartItems;
import org.mapstruct.factory.Mappers;

public interface CartMapperEntity {

    CartMapperEntity INSTANCE = Mappers.getMapper(CartMapperEntity.class);

    CartEntity toCartEntity(final Cart cart);

    CartItemsEntity toCartItemsEntity(final CartItems items);
}
