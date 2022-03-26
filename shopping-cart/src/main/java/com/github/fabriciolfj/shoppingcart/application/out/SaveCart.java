package com.github.fabriciolfj.shoppingcart.application.out;

import com.github.fabriciolfj.shoppingcart.domain.Cart;
import reactor.core.publisher.Mono;

public interface SaveCart {

    Mono<Void> execute(final Cart cart);
}
