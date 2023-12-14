package dev.patika.plus.yalnizapi.repository;

import dev.patika.plus.yalnizapi.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    @Query("SELECT pet FROM Pet pet where pet.name like %?1%")
    List<Pet> search(String query);


}