package dev.patika.plus.yalnizapi.structures.appointment;

import dev.patika.plus.yalnizapi.structures.animal.Animal;
import dev.patika.plus.yalnizapi.structures.vet.Vet;
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
@RequiredArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private LocalDateTime startDateTime;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "vet_id")
    private Vet vet;

}
