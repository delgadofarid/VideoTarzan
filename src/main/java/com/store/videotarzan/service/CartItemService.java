package com.store.videotarzan.service;

import com.store.videotarzan.model.Cart;
import com.store.videotarzan.model.CartItem;

public interface CartItemService {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByMovieId(Long movieId);

}
