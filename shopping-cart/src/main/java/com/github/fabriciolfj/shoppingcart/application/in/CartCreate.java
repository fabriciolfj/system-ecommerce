package com.github.fabriciolfj.shoppingcart.application.in;

import com.github.fabriciolfj.shoppingcart.application.CartService;
import com.github.fabriciolfj.shoppingcart.domain.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class CartCreate implements CartService {

    @Override
    public Mono<Void> execute(Cart cart) {
        return null;
    }
}
