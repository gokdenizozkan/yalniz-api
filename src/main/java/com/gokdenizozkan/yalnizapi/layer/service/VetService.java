package com.gokdenizozkan.yalnizapi.layer.service;

import com.gokdenizozkan.yalnizapi.config.datastructure.Pair;
import com.gokdenizozkan.yalnizapi.config.exception.ResourceNotFoundException;
import com.gokdenizozkan.yalnizapi.config.response.Data;
import com.gokdenizozkan.yalnizapi.dto.vet.VetEntityMappers;
import com.gokdenizozkan.yalnizapi.dto.vet.request.VetSaveRequest;
import com.gokdenizozkan.yalnizapi.entity.Vet;
import com.gokdenizozkan.yalnizapi.layer.repository.VetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VetService {
    private final VetRepository repository;
    private final VetEntityMappers entityMappers;

    public List<Vet> findAll() {
        return repository.findAll();
    }

    public Vet findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vet not found with id " + id));
    }

    public Vet save(VetSaveRequest request) {
        Vet vet = entityMappers.fromSaveRequest.apply(request);
        return repository.save(vet);
    }

    public Data update(Long id, VetSaveRequest request) {
        Vet foundVet = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vet not found with id " + id));

        Vet updatedVet = entityMappers.fromSaveRequest.apply(request);
        repository.save(updatedVet);

        return Data.of(Pair.of("old", foundVet), Pair.of("new", updatedVet));
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Vet not found with id " + id);
        }
        repository.deleteById(id);
    }
}
