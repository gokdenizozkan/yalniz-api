package com.gokdenizozkan.yalnizapi.layer.repository;

import com.gokdenizozkan.yalnizapi.entity.Workday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface WorkdayRepository extends JpaRepository<Workday, Long> {
    Boolean existsByVetIdAndDate(Long vetId, LocalDate date);
}
