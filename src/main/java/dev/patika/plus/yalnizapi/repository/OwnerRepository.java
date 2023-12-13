package dev.patika.plus.yalnizapi.repository;

import dev.patika.plus.yalnizapi.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Set<Owner> findByNameLikeIgnoreCase(String query);
}