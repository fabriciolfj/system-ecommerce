package com.github.fabriciolfj.shoppingcart.adapter.out.persistence.repository;

import com.github.fabriciolfj.shoppingcart.adapter.out.persistence.entity.CartEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CartRepository extends ReactiveCrudRepository<CartEntity, Long> {
}
