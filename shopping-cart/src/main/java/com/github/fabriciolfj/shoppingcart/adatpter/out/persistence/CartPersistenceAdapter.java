package com.github.fabriciolfj.shoppingcart.adatpter.out.persistence;

import com.github.fabriciolfj.shoppingcart.adatpter.out.persistence.repository.CartItemsRepository;
import com.github.fabriciolfj.shoppingcart.adatpter.out.persistence.repository.CartRepository;
import com.github.fabriciolfj.shoppingcart.application.out.SaveCart;
import com.github.fabriciolfj.shoppingcart.domain.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartPersistenceAdapter implements SaveCart {

    private final CartRepository cartRepository;
    private final CartItemsRepository cartItemsRepository;

    @Override
    public void execute(final Cart cart) {

    }
}
