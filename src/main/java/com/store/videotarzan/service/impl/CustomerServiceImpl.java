package com.store.videotarzan.service.impl;

import com.store.videotarzan.dao.CustomerDao;
import com.store.videotarzan.model.Customer;
import com.store.videotarzan.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<Customer> getCustomerList() {
        return customerDao.getCustomerList();
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return customerDao.getCustomerById(customerId);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    @Override
    public void editCustomer(Customer customer) {
        customerDao.editCustomer(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customerDao.deleteCustomer(customer);
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        return customerDao.getCustomerByUsername(username);
    }
}
