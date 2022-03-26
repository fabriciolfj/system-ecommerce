package com.github.fabriciolfj.shoppingcart.adapter.out.persistence;

import com.github.fabriciolfj.shoppingcart.adapter.out.persistence.entity.CartEntity;
import com.github.fabriciolfj.shoppingcart.adapter.out.persistence.entity.CartItemsEntity;
import com.github.fabriciolfj.shoppingcart.adapter.out.persistence.mapper.CartMapperEntity;
import com.github.fabriciolfj.shoppingcart.adapter.out.persistence.repository.CartItemsRepository;
import com.github.fabriciolfj.shoppingcart.adapter.out.persistence.repository.CartRepository;
import com.github.fabriciolfj.shoppingcart.application.out.SaveCart;
import com.github.fabriciolfj.shoppingcart.domain.Cart;
import com.github.fabriciolfj.shoppingcart.domain.CartItems;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class CartPersistenceAdapter implements SaveCart {

    private final CartRepository cartRepository;
    private final CartItemsRepository cartItemsRepository;

    @Override
    public Mono<Void> execute(final Cart cart) {
        return Mono.zip(Mono.just(cart), Mono.just(cart.getItems()))
                .flatMap(data -> {
                    saveCart(data.getT1());
                    saveItems(data.getT2());
                    return Mono.empty();
                });
    }

    private Mono<CartEntity> saveCart(final Cart cart) {
        return cartRepository.save(CartMapperEntity.INSTANCE.toCartEntity(cart));
    }

    private Flux<CartItemsEntity> saveItems(final List<CartItems> items) {
        return Flux.fromStream(items.stream())
                .map(it -> CartMapperEntity.INSTANCE.toCartItemsEntity(it))
                .flatMap(item -> cartItemsRepository.save(item))
                .doOnNext(v -> log.info("Item save: {}", v));
    }
}
