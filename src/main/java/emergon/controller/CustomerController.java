/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.controller;

import emergon.entity.Customer;
import emergon.service.CustomerService;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author gkolo
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
    
    
    @RequestMapping
    public ModelAndView showCustomers(ModelAndView modelAndView){
        List<Customer> customers = customerService.getCustomers();
        modelAndView.addObject("listOfCustomers", customers);
        modelAndView.setViewName("customerList");
        return modelAndView;
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showForm(){
        return "customerForm";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Customer customer, RedirectAttributes attributes){
        customerService.addCustomer(customer);
        String minima = "Customer " + customer.getCname() + " succesfully created";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/customer"; // Client send a new GET request to /customer
    }
    
    @GetMapping(value = "/delete")
    public String delete(@RequestParam(value = "id") int id, RedirectAttributes attributes){
        customerService.deleteCustomer(id);
        String minima = "Customer succesfully deleted";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/customer";
    }
    
    @GetMapping("/update/{ccode}")
    public String showFormUpdate(@PathVariable(name = "ccode") int ccode, Model model){
        Customer customer = customerService.getCustomerById(ccode);
        model.addAttribute("customerToEdit", customer);
        return "customerForm";
    }
    
    @PostMapping("/update")
    public String update(Customer customer, RedirectAttributes attributes){
        customerService.updateCustomer(customer);
        String minima = "Customer updated succesfully";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/customer";
    }
    
}
