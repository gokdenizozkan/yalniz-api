package dev.patika.plus.yalnizapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "Vaccination")
@Table(name = "vaccinations")

@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor
public class Vaccination {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String code;
    private LocalDate administrationDate;
    private LocalDate protectionEndDate;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "animal_id")
    @JsonIgnore
    private Pet pet;

}
