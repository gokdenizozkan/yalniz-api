package dev.patika.plus.yalnizapi.service;

import dev.patika.plus.yalnizapi.dto.owner.OwnerDto;
import dev.patika.plus.yalnizapi.dto.owner.OwnerDtoDemapper;
import dev.patika.plus.yalnizapi.dto.owner.OwnerDtoIntegrator;
import dev.patika.plus.yalnizapi.entity.Owner;
import dev.patika.plus.yalnizapi.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;
    private final OwnerDtoDemapper ownerDtoDemapper;
    private final OwnerDtoIntegrator ownerDtoIntegrator;

    public OwnerService(OwnerRepository ownerRepository, OwnerDtoDemapper ownerDtoDemapper, OwnerDtoIntegrator ownerDtoIntegrator) {
        this.ownerRepository = ownerRepository;
        this.ownerDtoDemapper = ownerDtoDemapper;
        this.ownerDtoIntegrator = ownerDtoIntegrator;
    }

    public Owner findById(long id) {
        return ownerRepository.findById(id).orElseThrow();
    }

    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    public Owner save(OwnerDto ownerDto) {
        Owner owner = ownerDtoDemapper.apply(ownerDto);
        return ownerRepository.save(owner);
    }

    public Owner updateById(long id, OwnerDto ownerDto) {
        OwnerDto ownerWithId = new OwnerDto(id, ownerDto.name(), ownerDto.phoneNumber(), ownerDto.email(), ownerDto.address(), ownerDto.city());
        Owner owner = ownerDtoIntegrator.apply(ownerWithId);
        return ownerRepository.save(owner);
    }

    public void deleteById(long id) {
        ownerRepository.deleteById(id);
    }

    public Set<Owner> search(String query) {
        return ownerRepository.findByNameLikeIgnoreCase(query);
    }
}
