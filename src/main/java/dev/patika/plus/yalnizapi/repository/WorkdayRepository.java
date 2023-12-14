package dev.patika.plus.yalnizapi.repository;

import dev.patika.plus.yalnizapi.entity.Workday;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface WorkdayRepository extends JpaRepository<Workday, Long> {
    boolean existsByVet_IdAndDate(Long id, LocalDate date);

}