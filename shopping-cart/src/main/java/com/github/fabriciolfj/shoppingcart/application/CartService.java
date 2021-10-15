package com.github.fabriciolfj.shoppingcart.application;

import com.github.fabriciolfj.shoppingcart.application.in.CartCreate;
import com.github.fabriciolfj.shoppingcart.domain.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CartService implements CartCreate {

    @Override
    public Mono<Void> execute(Cart cart) {
        return Mono.empty();
    }
}
