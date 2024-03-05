package com.gokdenizozkan.yalnizapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "workdays")
@Getter
@Setter
@RequiredArgsConstructor
public class Workday {
    @Id
    @GeneratedValue(generator = "WORKDAY_SEQ_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "WORKDAY_SEQ_GENERATOR", sequenceName = "WORKDAY_SEQ")
    private Long id;

    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vet_id", referencedColumnName = "id")
    private Vet vet;
}
