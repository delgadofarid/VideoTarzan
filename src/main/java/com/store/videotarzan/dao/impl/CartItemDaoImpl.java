package com.store.videotarzan.dao.impl;

import com.store.videotarzan.dao.CartItemDao;
import com.store.videotarzan.model.Cart;
import com.store.videotarzan.model.CartItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addCartItem(CartItem cartItem) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartItem);
        session.flush();
    }

    public void removeCartItem(CartItem cartItem) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(cartItem);
        session.flush();
    }

    public void removeAllCartItems(Cart cart) {
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem item : cartItems) {
            removeCartItem(item);
        }
        cart.setGrandTotal(0);
    }

    public CartItem getCartItemByMovieId(Long movieId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CartItem where movieId = ?1");
        query.setParameter(1, movieId);
        session.flush();

        return (CartItem) query.uniqueResult();
    }

}
