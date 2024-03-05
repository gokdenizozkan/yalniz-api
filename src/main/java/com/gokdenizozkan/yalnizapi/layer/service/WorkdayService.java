package com.gokdenizozkan.yalnizapi.layer.service;

import com.gokdenizozkan.yalnizapi.config.datastructure.Pair;
import com.gokdenizozkan.yalnizapi.config.exception.ResourceNotFoundException;
import com.gokdenizozkan.yalnizapi.config.response.Data;
import com.gokdenizozkan.yalnizapi.dto.workday.WorkdayEntityMappers;
import com.gokdenizozkan.yalnizapi.dto.workday.request.WorkdaySaveRequest;
import com.gokdenizozkan.yalnizapi.entity.Workday;
import com.gokdenizozkan.yalnizapi.layer.repository.WorkdayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkdayService {
    private final WorkdayRepository repository;
    private final WorkdayEntityMappers entityMappers;

    public List<Workday> findAll() {
        return repository.findAll();
    }

    public Workday findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Workday not found with id: " + id));
    }

    public Workday save(WorkdaySaveRequest request) {
        Workday workday = entityMappers.fromSaveRequest.apply(request);
        return repository.save(workday);
    }

    public Data update(Long id, WorkdaySaveRequest request) {
        Workday foundWorkday = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Workday not found with id: " + id));

        Workday updatedWorkday = entityMappers.fromSaveRequest.apply(request);
        repository.save(updatedWorkday);

        return Data.of(Pair.of("old", foundWorkday), Pair.of("new", updatedWorkday));
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Workday not found with id: " + id);
        }
        repository.deleteById(id);
    }
}