package com.store.videotarzan.service;

import com.store.videotarzan.model.Cart;

public interface CartService {

    Cart getCartById(Long cartId);

    void update(Cart cart);

}
