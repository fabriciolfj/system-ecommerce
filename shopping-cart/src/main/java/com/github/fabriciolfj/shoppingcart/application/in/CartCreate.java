package com.github.fabriciolfj.shoppingcart.application.in;

import com.github.fabriciolfj.shoppingcart.application.CartService;
import com.github.fabriciolfj.shoppingcart.application.out.SaveCart;
import com.github.fabriciolfj.shoppingcart.domain.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class CartCreate implements CartService {

    private final SaveCart saveCart;

    @Override
    public Mono<Void> execute(final Cart cart) {
        return Mono.just(cart)
                .doOnNext(c -> c.enrichmentInit())
                .flatMap(saveCart::execute);
    }
}
