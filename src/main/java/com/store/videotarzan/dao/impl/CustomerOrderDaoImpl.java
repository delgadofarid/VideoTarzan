package com.store.videotarzan.dao.impl;

import com.store.videotarzan.dao.CustomerOrderDao;
import com.store.videotarzan.model.Cart;
import com.store.videotarzan.model.Customer;
import com.store.videotarzan.model.CustomerOrder;
import com.store.videotarzan.service.CartItemService;
import com.store.videotarzan.service.CartService;
import com.store.videotarzan.service.MovieService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class CustomerOrderDaoImpl implements CustomerOrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private MovieService movieService;

    @Autowired
    private CartItemService cartItemService;

    public void addCustomerOrder(CustomerOrder customerOrder) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customerOrder);
        session.flush();
    }

    public List<CustomerOrder> getAllCustomerOrders() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CustomerOrder");
        List<CustomerOrder> customerOrders = query.list();
        session.flush();
        return customerOrders;
    }

    public void addCustomerOrder(Cart cart) {

        String cartDetails = cart.toString();

        cartItemService.removeAllCartItems(cart);

        movieService.updateUnitsInStock(cart.getCartItems());

        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setCart(cart);

        Customer customer = cart.getCustomer();
        customerOrder.setCustomer(customer);

        customerOrder.setOrderDate(new Date());
        customerOrder.setOrderDetails(cartDetails);

        addCustomerOrder(customerOrder);
    }
}
