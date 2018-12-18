package com.store.videotarzan.service.impl;

import com.store.videotarzan.dao.CartItemDao;
import com.store.videotarzan.model.Cart;
import com.store.videotarzan.model.CartItem;
import com.store.videotarzan.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemDao cartItemDao;

    public void addCartItem(CartItem cartItem) {
        cartItemDao.addCartItem(cartItem);
    }

    public void removeCartItem(CartItem cartItem) {
        cartItemDao.removeCartItem(cartItem);
    }

    public void removeAllCartItems(Cart cart) {
        cartItemDao.removeAllCartItems(cart);
    }

    public CartItem getCartItemByMovieId(Long movieId) {
        return cartItemDao.getCartItemByMovieId(movieId);
    }
}
