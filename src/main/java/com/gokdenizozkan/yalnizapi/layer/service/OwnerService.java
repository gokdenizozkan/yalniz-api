package com.gokdenizozkan.yalnizapi.layer.service;

import com.gokdenizozkan.yalnizapi.config.datastructure.Pair;
import com.gokdenizozkan.yalnizapi.config.exception.ResourceNotFoundException;
import com.gokdenizozkan.yalnizapi.config.response.Data;
import com.gokdenizozkan.yalnizapi.dto.owner.OwnerEntityMappers;
import com.gokdenizozkan.yalnizapi.dto.owner.request.OwnerSaveRequest;
import com.gokdenizozkan.yalnizapi.dto.owner.request.OwnerUpdateRequest;
import com.gokdenizozkan.yalnizapi.entity.Owner;
import com.gokdenizozkan.yalnizapi.entity.Pet;
import com.gokdenizozkan.yalnizapi.layer.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OwnerService {
    private final OwnerRepository repository;
    private final OwnerEntityMappers entityMappers;

    public List<Owner> findAll() {
        return repository.findAll();
    }


    public Owner findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found with id " + id));
    }

    public List<Owner> search(String name) {
        return repository.search(name);
    }

    public List<Pet> findPetsById(Long id) {
        Owner owner = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found with id " + id));
        return owner.getPets();
    }

    public Owner save(OwnerSaveRequest request) {
        Owner owner = entityMappers.fromSaveRequest.apply(request);
        return repository.save(owner);
    }

    public Data update(Long id, OwnerUpdateRequest request) {
        Owner foundOwner = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found with id " + id));

        Owner savedOwner = entityMappers.fromUpdateRequest.apply(request);
        repository.save(savedOwner);

        return Data.of(Pair.of("old", foundOwner), Pair.of("new", savedOwner));
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Owner not found with id " + id);
        }
        repository.deleteById(id);
    }
}
