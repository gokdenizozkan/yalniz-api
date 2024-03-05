package com.gokdenizozkan.yalnizapi.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "owners")
@Getter
@Setter
@RequiredArgsConstructor
public class Owner {
    @Id
    @GeneratedValue(generator = "OWNER_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "OWNER_SEQ_GEN", sequenceName = "OWNER_SEQ")
    private Long id;

    @NotNull
    private String name;
    @NotNull
    private String phone;
    @NotNull
    private String email;
    @NotNull
    private String address;
    @NotNull
    private String city;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.REMOVE)
    private List<Pet> pets;
}
