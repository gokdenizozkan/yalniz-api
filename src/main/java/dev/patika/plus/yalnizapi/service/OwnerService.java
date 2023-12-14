package dev.patika.plus.yalnizapi.service;

import dev.patika.plus.yalnizapi.dto.owner.OwnerDto;
import dev.patika.plus.yalnizapi.dto.owner.OwnerDtoDemapper;
import dev.patika.plus.yalnizapi.dto.owner.OwnerDtoIntegrator;
import dev.patika.plus.yalnizapi.entity.Owner;
import dev.patika.plus.yalnizapi.entity.Pet;
import dev.patika.plus.yalnizapi.entity.response.Response;
import dev.patika.plus.yalnizapi.entity.response.ResponseBuilder;
import dev.patika.plus.yalnizapi.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public Response<Owner> findById(long id) {
        return ResponseBuilder.auto(ownerRepository.findById(id).orElse(null));
    }

    public Response<List<Owner>> findAll() {
        return ResponseBuilder.auto(ownerRepository.findAll());
    }

    public Response<Owner> save(OwnerDto ownerDto) {
        Owner owner = ownerDtoDemapper.apply(ownerDto);
        return ResponseBuilder.templateSuccess(ownerRepository.save(owner));
    }

    public Response<Owner> updateById(OwnerDto ownerDto) {
        return ResponseBuilder.templateSuccess(ownerRepository.save(ownerDtoIntegrator.apply(ownerDto)));
    }

    public Response<Owner> deleteById(long id) {
        if (!ownerRepository.existsById(id)) {
            return ResponseBuilder.templateFail("Owner with id " + id + " does not exist!");
        }
        ownerRepository.deleteById(id);
        return ResponseBuilder.templateSuccess(null);
    }

    public Response<List<Owner>> search(String query) {
        return ResponseBuilder.templateSuccess(ownerRepository.search(query));
    }

    public Response<Set<Pet>> findPetsById(long id) {
        Optional<Owner> ownerOptional = ownerRepository.findById(id);
        if (ownerOptional.isEmpty()) return ResponseBuilder.templateFail("Owner not found");
        return ResponseBuilder.templateSuccess(ownerOptional.get().getPets());
    }
}
