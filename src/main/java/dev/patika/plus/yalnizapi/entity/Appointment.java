package dev.patika.plus.yalnizapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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
    @JoinColumn(name = "pet_id")
    @JsonIgnore
    private Pet pet;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "vet_id")
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnore
    private Vet vet;

}
