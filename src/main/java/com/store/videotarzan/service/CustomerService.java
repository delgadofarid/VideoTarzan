package com.store.videotarzan.service;

import com.store.videotarzan.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomerList();

    Customer getCustomerById(Long customerId);

    Customer getCustomerByUsername(String username);

    void addCustomer(Customer customer);

    void editCustomer(Customer customer);

    void deleteCustomer(Customer customer);

}
