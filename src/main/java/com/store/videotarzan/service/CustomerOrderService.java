package com.store.videotarzan.service;

import com.store.videotarzan.model.CustomerOrder;

import java.util.List;

public interface CustomerOrderService {

    List<CustomerOrder> getAllCustomerOrders();

    void addCustomerOrder(CustomerOrder customerOrder);

    double getCustomerOrderGrandTotal(Long cartId);

}
