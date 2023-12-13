package dev.patika.plus.yalnizapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "Workday")
@Table(name = "workdays")

@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor
public class Workday {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate date;

    @ToString.Exclude
    @ManyToOne()
    @JoinColumn(name = "vet_id")
    @JsonIgnore
    private Vet vet;

}
