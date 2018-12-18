package com.store.videotarzan.dao.impl;

import com.store.videotarzan.dao.CustomerDao;
import com.store.videotarzan.model.Authorities;
import com.store.videotarzan.model.Cart;
import com.store.videotarzan.model.Customer;
import com.store.videotarzan.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);

        Users newUser = new Users();
        newUser.setUsername(customer.getUsername());
        newUser.setPassword(customer.getPassword());
        newUser.setEnabled(true);
        newUser.setCustomerId(customer.getCustomerId());

        Authorities newAuthority = new Authorities();
        newAuthority.setUsername(customer.getUsername());
        newAuthority.setAuthority("ROLE_USER");

        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthority);

        Cart newCart = new Cart();
        newCart.setCustomer(customer);
        customer.setCart(newCart);
        session.saveOrUpdate(customer);
        session.saveOrUpdate(newCart);

        session.flush();
    }

    @Override
    public List<Customer> getCustomerList() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer");
        List<Customer> customers = query.list();
        session.flush();
        return customers;
    }

    @Override
    public Customer getCustomerById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, id);
        session.flush();
        return customer;
    }

    @Override
    public void editCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(customer);
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer where username = ?1");
        query.setParameter(1, username);
        Customer customer = (Customer) query.uniqueResult();
        session.flush();
        return customer;
    }
}
