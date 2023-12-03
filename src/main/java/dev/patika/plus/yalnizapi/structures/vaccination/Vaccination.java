package dev.patika.plus.yalnizapi.structures.vaccination;

import dev.patika.plus.yalnizapi.structures.animal.Animal;
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
@RequiredArgsConstructor
public class Vaccination {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String code;
    private LocalDate administrationDate;
    private LocalDate protectionEndDate;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "animal_id")
    private Animal animal;

}
