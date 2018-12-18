package com.store.videotarzan.service.impl;

import com.store.videotarzan.dao.CustomerOrderDao;
import com.store.videotarzan.model.Cart;
import com.store.videotarzan.model.CartItem;
import com.store.videotarzan.model.CustomerOrder;
import com.store.videotarzan.service.CartService;
import com.store.videotarzan.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Autowired
    private CartService cartService;


    public void addCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDao.addCustomerOrder(customerOrder);
    }

    public double getCustomerOrderGrandTotal(Long cartId) {
        double grandTotal = 0;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem cartItem : cartItems) {
            grandTotal += cartItem.getTotalPrice();
        }
        return grandTotal;
    }

    public List<CustomerOrder> getAllCustomerOrders() {
        return customerOrderDao.getAllCustomerOrders();
    }
}
