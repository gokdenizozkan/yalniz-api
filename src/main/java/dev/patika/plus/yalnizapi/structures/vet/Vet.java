package dev.patika.plus.yalnizapi.structures.vet;

import dev.patika.plus.yalnizapi.structures.appointment.Appointment;
import dev.patika.plus.yalnizapi.structures.workday.Workday;
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
@RequiredArgsConstructor
public class Vet {
    @Id
    @GeneratedValue()
    private int id;
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;
    private String address;
    private String city;

    @OneToMany(mappedBy = "vet")
    private Set<Appointment> appointments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "vet")
    private Set<Workday> workdays = new LinkedHashSet<>();

}
