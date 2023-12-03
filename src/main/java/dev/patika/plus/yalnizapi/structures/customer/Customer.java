package dev.patika.plus.yalnizapi.structures.customer;

import dev.patika.plus.yalnizapi.structures.animal.Animal;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = "Customer")
@Table(name = "customers")

@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer {
    @Id
    @GeneratedValue()
    private long id;
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;
    private String address;
    private String city;


    @OneToMany(mappedBy = "customer")
    private Set<Animal> animals = new LinkedHashSet<>();

}
