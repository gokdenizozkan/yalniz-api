package dev.patika.plus.yalnizapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = "Pet")
@Table(name = "pets")

@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String species;
    private String breed;
    private String gender;
    private String color;
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    @JsonIgnore
    private Owner owner;

    @ToString.Exclude
    @OneToMany(mappedBy = "pet", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Appointment> appointments = new LinkedHashSet<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "pet", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Vaccination> vaccinations = new LinkedHashSet<>();
}
