package dev.patika.plus.yalnizapi.structures.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    Set<Animal> findByNameLikeIgnoreCase(String name);


}