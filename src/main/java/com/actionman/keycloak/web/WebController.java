package com.actionman.keycloak.web;

import java.security.Principal;

import com.actionman.keycloak.dao.CustomerDAO;
import com.actionman.keycloak.model.Customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * WebController
 */
@Controller
public class WebController {

    private CustomerDAO customerDAO;

    public WebController(CustomerDAO customerDAO) {
        this.customerDAO =  customerDAO;
    }

    @GetMapping(path = "/")
    public String index() {
        return "external";
    }
        
    @GetMapping(path = "/customers")
    public String customers(Principal principal, Model model) {
        addCustomers();
        model.addAttribute("customers", customerDAO.findAll());
        model.addAttribute("username", principal.getName());
        return "customers";
    }

    public void addCustomers() {

        Customer customer1 = new Customer();
        customer1.setAddress("1111 foo blvd");
        customer1.setName("Foo Industries");
        customer1.setServiceRendered("Important services");
        customerDAO.save(customer1);

        Customer customer2 = new Customer();
        customer2.setAddress("2222 bar street");
        customer2.setName("Bar LLP");
        customer2.setServiceRendered("Important services");
        customerDAO.save(customer2);

        Customer customer3 = new Customer();
        customer3.setAddress("33 main street");
        customer3.setName("Big LLC");
        customer3.setServiceRendered("Important services");
        customerDAO.save(customer3);
    }
}