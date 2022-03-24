package com.github.fabriciolfj.shoppingcart.adapter.in.controller.mapper;

import com.github.fabriciolfj.shoppingcart.adapter.in.controller.dto.CartRequestDTO;
import com.github.fabriciolfj.shoppingcart.domain.Cart;
import org.mapstruct.factory.Mappers;

public interface CartMapper {

    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    Cart toDomain(final CartRequestDTO dto);
}
