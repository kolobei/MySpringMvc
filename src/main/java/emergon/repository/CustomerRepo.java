/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.repository;

import emergon.entity.Customer;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gkolo
 */
@Repository
public class CustomerRepo extends HibernateUtil<Customer>{
    
//    @Autowired
//    private SessionFactory sessionFactory;
    
//    public List<Customer> findAll(){
//        Session session = sessionFactory.openSession();
//        Query<Customer> query = session.createNamedQuery("Customer.findAll", Customer.class);
//        List<Customer> customers = query.getResultList();
//
//        return customers;
//    }
    
    public List<Customer> findAll(){
        return super.findAll("Customer.findAll");
    }
    
    @Override
    public Customer save(Customer customer){
        return super.save(customer);
    }
    
    public Customer find(int id){
        return super.find(Customer.class, id);
    
    }
    
    
}
