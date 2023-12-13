package dev.patika.plus.yalnizapi.repository;

import dev.patika.plus.yalnizapi.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    Set<Pet> findByNameLikeIgnoreCase(String name);


}