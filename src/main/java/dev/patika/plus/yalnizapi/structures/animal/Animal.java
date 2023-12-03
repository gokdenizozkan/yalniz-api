package dev.patika.plus.yalnizapi.structures.animal;

import dev.patika.plus.yalnizapi.structures.appointment.Appointment;
import dev.patika.plus.yalnizapi.structures.customer.Customer;
import dev.patika.plus.yalnizapi.structures.vaccination.Vaccination;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = "Animal")
@Table(name = "animals")

@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Animal {
    @Id
    private long id;
    private String name;
    private String species;
    private String breed;
    private String gender;
    private String color;
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @ToString.Exclude
    @OneToMany(mappedBy = "animal", orphanRemoval = true)
    private Set<Appointment> appointments = new LinkedHashSet<>();

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ToString.Exclude
    @OneToMany(mappedBy = "animal")
    private Set<Vaccination> vaccinations = new LinkedHashSet<>();

}
