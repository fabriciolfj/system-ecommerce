package com.github.fabriciolfj.shoppingcart.adatpter.out.persistence.repository;

import com.github.fabriciolfj.shoppingcart.adatpter.out.persistence.entity.CartEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CartRepository extends ReactiveCrudRepository<CartEntity, Long> {
}
