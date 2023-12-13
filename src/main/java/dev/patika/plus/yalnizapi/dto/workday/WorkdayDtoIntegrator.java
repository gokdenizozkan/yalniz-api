package dev.patika.plus.yalnizapi.dto.workday;

import dev.patika.plus.yalnizapi.entity.Workday;
import dev.patika.plus.yalnizapi.repository.VetRepository;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * DTO Integrator for {@link dev.patika.plus.yalnizapi.dto.workday.WorkdayDto}
 */
@Service
public class WorkdayDtoIntegrator implements Function<WorkdayDto, Workday> {
    private final VetRepository vetRepository;

    public WorkdayDtoIntegrator(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Workday apply(WorkdayDto workdayDto) {
        Workday workday = new Workday();

        if (workdayDto.id() != null) workday.setId(workdayDto.id());
        workday.setDate(workdayDto.date());
        workday.setVet(vetRepository.findById(workdayDto.vetId()).orElseThrow(() -> new IllegalArgumentException("Vet not found with id: " + workdayDto.vetId())));

        return workday;
    }
}
