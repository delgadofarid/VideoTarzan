package com.store.videotarzan.dao.impl;

import com.store.videotarzan.dao.CartDao;
import com.store.videotarzan.model.Cart;
import com.store.videotarzan.model.CartItem;
import com.store.videotarzan.model.Movie;
import com.store.videotarzan.service.CustomerOrderService;
import com.store.videotarzan.service.MovieService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private CustomerOrderService customerOrderService;

    @Autowired
    private MovieService movieService;

    public Cart getCartById(Long cartId) {
        Session session = sessionFactory.getCurrentSession();
        Cart cart = session.get(Cart.class, cartId);
        session.flush();
        return cart;
    }

    public void update(Cart cart) {
        Long cartId = cart.getCartId();
        double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cartId);
        cart.setGrandTotal(grandTotal);
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);
        session.flush();
    }

    public Cart validate(Long cartId) throws IOException, IllegalArgumentException {
        Cart cart = getCartById(cartId);
        if (cart == null || cart.getCartItems().size() == 0) {
            throw new IOException(cartId + "");
        }
        for (CartItem item: cart.getCartItems()) {
            Movie movie = movieService.getMovieById(item.getMovie().getMovieId());
            if (movie.getUnitInStock() < item.getQuantity()) {
                throw new IllegalArgumentException(item.getCart().getCartId() + "");
            }
        }
        update(cart);
        return cart;
    }
}
