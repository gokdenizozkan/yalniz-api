package dev.patika.plus.yalnizapi.structures.workday;

import dev.patika.plus.yalnizapi.structures.vet.Vet;
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
@RequiredArgsConstructor
public class Workday {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private long id;
    private LocalDate date;

    @ToString.Exclude
    @ManyToOne()
    @JoinColumn(name = "vet_id")
    private Vet vet;

}
