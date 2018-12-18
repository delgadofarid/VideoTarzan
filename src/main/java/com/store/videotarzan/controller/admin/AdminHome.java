package com.store.videotarzan.controller.admin;

import com.store.videotarzan.model.Customer;
import com.store.videotarzan.model.CustomerOrder;
import com.store.videotarzan.model.Movie;
import com.store.videotarzan.service.CustomerOrderService;
import com.store.videotarzan.service.CustomerService;
import com.store.videotarzan.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminHome {

    @Autowired
    private MovieService movieService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @RequestMapping
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/movieInventory")
    public String movieInventory(Model model) {
        List<Movie> movies = movieService.getMovieList();
        model.addAttribute("movies", movies);
        return "movieInventory";
    }

    @RequestMapping("/customer")
    public String customerManagement(Model model) {
        List<Customer> customerList = customerService.getCustomerList();
        model.addAttribute("customerList", customerList);
        return "customerManagement";
    }

    @RequestMapping("/order")
    public String orderManagement(Model model) {
        List<CustomerOrder> customerOrderList = customerOrderService.getAllCustomerOrders();
        model.addAttribute("customerOrderList", customerOrderList);
        return "orderManagement";
    }

}
