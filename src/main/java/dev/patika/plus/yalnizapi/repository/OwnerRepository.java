package dev.patika.plus.yalnizapi.repository;

import dev.patika.plus.yalnizapi.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    @Query("SELECT o FROM Owner o WHERE o.name LIKE %?1%")
    List<Owner> search(String query);


}