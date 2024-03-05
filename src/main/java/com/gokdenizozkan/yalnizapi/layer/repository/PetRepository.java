package com.gokdenizozkan.yalnizapi.layer.repository;

import com.gokdenizozkan.yalnizapi.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findAllByOwnerId(Long id);

    List<Pet> findAllByNameContaining(String name);
}
