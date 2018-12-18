package com.store.videotarzan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Cart implements Serializable {

    private static final long serialVersionUID = 7702930372988306099L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CartItem> cartItems;

    @OneToOne
    @JoinColumn(name = "customerId")
    @JsonIgnore
    private Customer customer;

    private double grandTotal;

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    @Override
    public String toString() {
        String cartString = "# movies: " + this.cartItems.size() + ".\n\n" +
                "Booked list:\n";
        int totalItems = 0;
        for (int i = 0; i < this.cartItems.size(); i++) {
            cartString += ( i + 1 ) + ". " + this.cartItems.get(i) + "\n";
            totalItems += this.cartItems.get(i).getQuantity();
        }
        cartString += "\nTotal items: " + totalItems;
        cartString += "\nGrand total: " + this.grandTotal;
        return cartString;
    }

}
