package com.store.videotarzan.dao;

import com.store.videotarzan.model.Cart;
import com.store.videotarzan.model.CartItem;

import java.util.List;

public interface CartItemDao {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByMovieId(Long movieId);

}
