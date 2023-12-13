package dev.patika.plus.yalnizapi.repository;

import dev.patika.plus.yalnizapi.entity.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetRepository extends JpaRepository<Vet, Long> {
}