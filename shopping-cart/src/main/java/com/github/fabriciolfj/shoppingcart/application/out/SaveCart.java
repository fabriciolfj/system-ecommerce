package com.github.fabriciolfj.shoppingcart.application.out;

import com.github.fabriciolfj.shoppingcart.domain.Cart;

public interface SaveCart {

    void execute(final Cart cart);
}
