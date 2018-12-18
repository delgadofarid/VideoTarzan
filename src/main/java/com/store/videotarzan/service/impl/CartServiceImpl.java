package com.store.videotarzan.service.impl;

import com.store.videotarzan.dao.CartDao;
import com.store.videotarzan.model.Cart;
import com.store.videotarzan.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    @Override
    public Cart getCartById(Long cartId) {
        return cartDao.getCartById(cartId);
    }

    @Override
    public void update(Cart cart) {
        cartDao.update(cart);
    }
}
