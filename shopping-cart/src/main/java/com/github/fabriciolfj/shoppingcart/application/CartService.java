package com.github.fabriciolfj.shoppingcart.application;

import com.github.fabriciolfj.shoppingcart.domain.Cart;
import reactor.core.publisher.Mono;

public interface CartService {

    Mono<Void> execute(final Cart cart);
}
