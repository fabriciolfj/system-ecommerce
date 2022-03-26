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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class CartPersistenceAdapter implements SaveCart {

    private final CartRepository cartRepository;
    private final CartItemsRepository cartItemsRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Mono<Void> execute(final Cart cart) {
        return saveCart(cart)
                .map(c -> c.getId())
                .flatMap(id -> saveItems(cart.getItems(), id)
                        .collectList())
                .flatMap(r -> {
                    log.info("Items save {}", r.size());
                    return Mono.empty();
                });
    }

    private Mono<CartEntity> saveCart(final Cart cart) {
        return cartRepository.save(CartMapperEntity.toCartEntity(cart))
                .log();
    }

    private Flux<CartItemsEntity> saveItems(final List<CartItems> items, final Long cartId) {
        return Flux.fromIterable(items)
                //.map(it -> CartMapperEntity.toCartItemsEntity(it, cartId))
                .flatMap(item -> {
                    var entity = CartMapperEntity.toCartItemsEntity(item, cartId);
                    return cartItemsRepository.save(entity);
                })
                .doOnNext(v -> log.info("Item save: {}", v))
                .doOnError(e -> log.error(e.getMessage()));
    }

    /*private Mono<Void> saveItems(final List<CartItems> items, final Long cartId) {
        return Flux.fromIterable(items)
                .map(it -> CartMapperEntity.toCartItemsEntity(it, cartId))
                .flatMap(item -> cartItemsRepository.save(item))
                .doOnNext(v -> log.info("Item save: {}", v))
                .doOnError(e -> log.error(e.getMessage()))
                .then();
    }*/
}
