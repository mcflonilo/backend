package com.example.jpademo.customer;

import com.example.jpademo.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.jpademo.customer.CustomerRepo;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo){
        this.customerRepo = customerRepo;
    }

    public List<Customer> getCustomers(){
        return customerRepo.findAll();
    }
    public Customer getCustomer(Long customerId){
        return customerRepo.findById(customerId).orElseThrow(() -> new IllegalStateException("Customer with id " + customerId + " does not exist"));
    }
    public Customer createCustomer(Customer customer){
        return customerRepo.save(customer);
    }
    public Customer updateCustomer(Customer customer){
        return customerRepo.save(customer);
    }
    public void deleteCustomer(Long customerId){
        customerRepo.deleteById(customerId);
    }
    public Customer updateCustomerName(Long customerId, String customerName){
        Customer customer = customerRepo.findById(customerId).orElseThrow(() -> new IllegalStateException("Customer with id " + customerId + " does not exist"));
        customer.setCustomerName(customerName);
        return customerRepo.save(customer);
    }
}
