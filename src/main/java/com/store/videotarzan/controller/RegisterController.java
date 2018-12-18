package com.store.videotarzan.controller;

import com.store.videotarzan.model.Customer;
import com.store.videotarzan.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/register")
    public String registerCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "registerCustomer";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerCustomerPost(@Valid @ModelAttribute("customer") Customer customer,
                                       BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registerCustomer";
        }

        List<Customer> customerList = customerService.getCustomerList();

        for (Customer c : customerList) {
            if (customer.getCustomerEmail().equals(c.getCustomerEmail())) {
                model.addAttribute("emailMsg", "Email already exists");
                return "registerCustomer";
            }
            if (customer.getUsername().equals(c.getUsername())) {
                model.addAttribute("usernameMsg", "Username already exists");
                return "registerCustomer";
            }
        }

        customer.setEnabled(true);
        customerService.addCustomer(customer);
        return "registerCustomerSuccess";
    }

}
