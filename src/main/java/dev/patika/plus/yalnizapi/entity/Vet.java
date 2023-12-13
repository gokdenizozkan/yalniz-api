package dev.patika.plus.yalnizapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = "Vet")
@Table(name = "vets")

@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor
public class Vet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;
    private String address;
    private String city;

    @OneToMany(mappedBy = "vet")
    @JsonIgnore
    private Set<Appointment> appointments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "vet")
    @JsonIgnore
    private Set<Workday> workdays = new LinkedHashSet<>();

}
