/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author gkolo
 */
@Service
public class CustomerService {

    private List<Customer> customers;

    public List<Customer> getCustomers() {
        if (customers == null) {
            customers = new ArrayList();
            customers.add(new Customer(1, "Giorgos"));
            customers.add(new Customer(2, "Jenny"));
            customers.add(new Customer(3, "Alisia"));
        }
        return customers;
    }

//    public List<Customer> getCustomers(){
//        return customers;
//    }
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void deleteCustomer(int id) {
        for (Customer c : customers) {
            if (c.getCcode().equals(id)) {
                customers.remove(c);
                break;
            }
        }
    }

    public Customer getCustomerById(int ccode) {
        for(Customer c : customers){
            if(c.getCcode() == ccode){
                return c;
            }
        }
        return null;
    }

    public Customer updateCustomer(Customer customer) { // customer argument contains a new data from the form
        // Find customer from list and add it to the variable customerToUpdate
        Customer customerToUpdate = getCustomerById(customer.getCcode());
        customerToUpdate.setCname(customer.getCname());
        return customerToUpdate;
    }

}
