package com.gokdenizozkan.yalnizapi.layer.repository;

import com.gokdenizozkan.yalnizapi.entity.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepository extends JpaRepository<Vet, Long> {

}
