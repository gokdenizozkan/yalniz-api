package com.gokdenizozkan.yalnizapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pets")
@Getter
@Setter
@RequiredArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(generator = "PET_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "PET_SEQ_GEN", sequenceName = "PET_SEQ")
    private Long id;

    private String name;
    private String species;
    private String breed;
    private String gender;
    private String color;
    private LocalDate birthdate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    @JsonIgnore
    private Owner owner;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.REMOVE)
    private List<Vaccination> vaccinations;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.REMOVE)
    private List<Appointment> appointments;
}
