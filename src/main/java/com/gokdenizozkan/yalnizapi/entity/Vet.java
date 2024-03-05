package com.gokdenizozkan.yalnizapi.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "vets")
@Getter
@Setter
@RequiredArgsConstructor
public class Vet {
    @Id
    @GeneratedValue(generator = "VET_SEQ_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "VET_SEQ_GENERATOR", sequenceName = "VET_SEQ")
    private Long id;

    private String name;
    private String phone;
    private String email;
    private String address;
    private String city;

    @OneToMany(mappedBy = "vet", cascade = CascadeType.REMOVE)
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "vet", cascade = CascadeType.REMOVE)
    private List<Workday> workdays;
}
