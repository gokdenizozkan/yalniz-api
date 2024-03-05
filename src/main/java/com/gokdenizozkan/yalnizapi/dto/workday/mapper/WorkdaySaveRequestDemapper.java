package com.gokdenizozkan.yalnizapi.dto.workday.mapper;

import com.gokdenizozkan.yalnizapi.config.exception.ResourceNotFoundException;
import com.gokdenizozkan.yalnizapi.dto.workday.request.WorkdaySaveRequest;
import com.gokdenizozkan.yalnizapi.entity.Workday;
import com.gokdenizozkan.yalnizapi.layer.repository.VetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class WorkdaySaveRequestDemapper implements Function<WorkdaySaveRequest, Workday> {
    private final VetRepository vetRepository;

    @Override
    public Workday apply(WorkdaySaveRequest workdaySaveRequest) {
        Workday workday = new Workday();

        workday.setDate(workdaySaveRequest.date());
        workday.setVet(vetRepository.findById(workdaySaveRequest.vetId())
                .orElseThrow(() -> new ResourceNotFoundException("Vet not found with id: " + workdaySaveRequest.vetId())));

        return workday;
    }
}
