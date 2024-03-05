package com.gokdenizozkan.yalnizapi.entity;

import jakarta.persistence.Column;
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

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@RequiredArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(generator = "APPOINTMENT_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "APPOINTMENT_SEQ_GEN", sequenceName = "APPOINTMENT_SEQ")
    private Long id;

    @Column(name = "start_date")
    private LocalDateTime start;
    @Column(name = "end_date")
    private LocalDateTime end;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id", referencedColumnName = "id")
    private Pet pet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vet_id", referencedColumnName = "id")
    private Vet vet;
}
