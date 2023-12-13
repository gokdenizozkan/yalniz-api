package dev.patika.plus.yalnizapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "Appointment")
@Table(name = "appointments")

@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDateTime startDateTime;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "animal_id")
    @JsonIgnore
    private Pet pet;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "vet_id")
    @JsonIgnore
    private Vet vet;

}
