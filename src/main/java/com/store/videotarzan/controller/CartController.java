package com.store.videotarzan.controller;

import com.store.videotarzan.model.Customer;
import com.store.videotarzan.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer/cart")
public class CartController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping
    public String getCart(@AuthenticationPrincipal User activeUser) {
        Customer customer = customerService.getCustomerByUsername (activeUser.getUsername());
        Long cartId = customer.getCart().getCartId();
        return "redirect:/customer/cart/" + cartId;
    }

    @RequestMapping("/{id}")
    public String getCartRedirect(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("cartId", id);
        return "cart";
    }


}
