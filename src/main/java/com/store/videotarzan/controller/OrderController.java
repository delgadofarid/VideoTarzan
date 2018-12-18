package com.store.videotarzan.controller;

import com.store.videotarzan.model.Cart;
import com.store.videotarzan.model.Customer;
import com.store.videotarzan.model.CustomerOrder;
import com.store.videotarzan.service.CartService;
import com.store.videotarzan.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class OrderController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @RequestMapping("/order/{cartId}")
    public String createOrder(@PathVariable(name = "cartId") Long cartId) {
        return "redirect:/checkout?cartId=" + cartId;
    }

}
