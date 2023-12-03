package dev.patika.plus.yalnizapi.structures.customer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findById(long id) {
        return customerRepository.findById(id).orElseThrow();
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public void updateById(long id, Customer customer) {
        if (customerRepository.existsById(id)) {
            customer.setId(id);
            customerRepository.save(customer);
        }
    }

    public void deleteById(long id) {
        customerRepository.deleteById(id);
    }

    public Set<Customer> search(String query) {
        return customerRepository.findByNameLikeIgnoreCase(query);
    }
}
