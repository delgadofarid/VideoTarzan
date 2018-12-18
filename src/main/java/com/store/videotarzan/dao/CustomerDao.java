package com.store.videotarzan.dao;

import com.store.videotarzan.model.Customer;

import java.util.List;

public interface CustomerDao {

    List<Customer> getCustomerList();

    Customer getCustomerById(Long customerId);

    void addCustomer(Customer customer);

    void editCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    Customer getCustomerByUsername(String username);

}
