package com.github.fabriciolfj.shoppingcart.application.in;

import com.github.fabriciolfj.shoppingcart.domain.Cart;
import reactor.core.publisher.Mono;

public interface CartCreate {

    Mono<Void> execute(final Cart cart);
}
