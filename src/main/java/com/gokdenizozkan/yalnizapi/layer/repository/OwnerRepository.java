package com.gokdenizozkan.yalnizapi.layer.repository;

import com.gokdenizozkan.yalnizapi.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    @Query("SELECT o FROM Owner o WHERE o.name LIKE %?1%")
    List<Owner> search(String name);

}
