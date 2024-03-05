package com.gokdenizozkan.yalnizapi.dto.workday.mapper;

import com.gokdenizozkan.yalnizapi.config.exception.ResourceNotFoundException;
import com.gokdenizozkan.yalnizapi.dto.workday.request.WorkdayUpdateRequest;
import com.gokdenizozkan.yalnizapi.entity.Workday;
import com.gokdenizozkan.yalnizapi.layer.repository.VetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class WorkdayUpdateRequestDemapper implements Function<WorkdayUpdateRequest, Workday> {
    private final VetRepository vetRepository;

    @Override
    public Workday apply(WorkdayUpdateRequest workdayUpdateRequest) {
        Workday workday = new Workday();

        workday.setId(workdayUpdateRequest.id());
        workday.setDate(workdayUpdateRequest.date());
        workday.setVet(vetRepository.findById(workdayUpdateRequest.vetId())
                .orElseThrow(() -> new ResourceNotFoundException("Vet not found with id: " + workdayUpdateRequest.vetId())));

        return workday;
    }
}
