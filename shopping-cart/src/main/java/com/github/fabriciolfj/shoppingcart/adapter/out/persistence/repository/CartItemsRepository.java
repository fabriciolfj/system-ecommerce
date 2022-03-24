package com.github.fabriciolfj.shoppingcart.adapter.out.persistence.repository;

import com.github.fabriciolfj.shoppingcart.adapter.out.persistence.entity.CartItemsEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CartItemsRepository extends ReactiveCrudRepository<CartItemsEntity, Long> {
}
