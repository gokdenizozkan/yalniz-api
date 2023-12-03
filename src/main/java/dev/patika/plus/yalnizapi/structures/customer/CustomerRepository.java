package dev.patika.plus.yalnizapi.structures.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Set<Customer> findByNameLikeIgnoreCase(String query);
}