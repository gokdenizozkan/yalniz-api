package dev.patika.plus.yalnizapi.repository;

import dev.patika.plus.yalnizapi.entity.Workday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkdayRepository extends JpaRepository<Workday, Long> {
}