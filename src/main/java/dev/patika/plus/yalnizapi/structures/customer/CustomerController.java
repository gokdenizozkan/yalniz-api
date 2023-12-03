package dev.patika.plus.yalnizapi.structures.customer;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable long id) {
        return customerService.findById(id);
    }

    @GetMapping("/search")
    public Set<Customer> search(@PathParam(value = "name") String query) {
        return customerService.search(query);
    }

    @PostMapping
    public Customer save(Customer customer) {
        return customerService.save(customer);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody Customer customer) {
        customerService.updateById(id, customer);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        customerService.deleteById(id);
    }
}
