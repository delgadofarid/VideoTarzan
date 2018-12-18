package com.store.videotarzan.dao;

import com.store.videotarzan.model.Cart;
import com.store.videotarzan.model.CustomerOrder;

import java.util.List;

public interface CustomerOrderDao {

    void addCustomerOrder(CustomerOrder customerOrder);

    List<CustomerOrder> getAllCustomerOrders();

    void addCustomerOrder(Cart cart);

}
