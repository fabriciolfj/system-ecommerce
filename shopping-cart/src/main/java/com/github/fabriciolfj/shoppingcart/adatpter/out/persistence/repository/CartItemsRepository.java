package com.github.fabriciolfj.shoppingcart.adatpter.out.persistence.repository;

import com.github.fabriciolfj.shoppingcart.adatpter.out.persistence.entity.CartItemsEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CartItemsRepository extends ReactiveCrudRepository<CartItemsEntity, Long> {
}
