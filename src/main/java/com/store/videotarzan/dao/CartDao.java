package com.store.videotarzan.dao;

import com.store.videotarzan.model.Cart;

import java.io.IOException;

public interface CartDao {

    Cart getCartById (Long cartId);

    void update (Cart cart);

    Cart validate(Long cartId) throws IOException;

}
