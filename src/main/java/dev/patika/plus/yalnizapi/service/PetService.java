package dev.patika.plus.yalnizapi.service;

import dev.patika.plus.yalnizapi.dto.pet.PetDto;
import dev.patika.plus.yalnizapi.dto.pet.PetDtoDemapper;
import dev.patika.plus.yalnizapi.dto.pet.PetDtoIntegrator;
import dev.patika.plus.yalnizapi.entity.Pet;
import dev.patika.plus.yalnizapi.entity.response.Response;
import dev.patika.plus.yalnizapi.entity.response.ResponseBuilder;
import dev.patika.plus.yalnizapi.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    private final PetRepository petRepository;
    private final PetDtoIntegrator petDtoIntegrator;
    private final PetDtoDemapper petDtoDemapper;

    public PetService(PetRepository petRepository, PetDtoIntegrator petDtoIntegrator, PetDtoDemapper petDtoDemapper) {
        this.petRepository = petRepository;
        this.petDtoIntegrator = petDtoIntegrator;
        this.petDtoDemapper = petDtoDemapper;
    }

    public Response<Pet> findById(long id) {
        return ResponseBuilder.auto(petRepository.findById(id).orElse(null));
    }

    public Response<List<Pet>> findAll() {
        return ResponseBuilder.templateSuccess(petRepository.findAll());
    }

    public Response<List<Pet>> search(String query) {
        return ResponseBuilder.templateSuccess(petRepository.search(query));
    }

    public Response<Pet> save(PetDto petDto) {
        return ResponseBuilder.templateSuccess(petRepository.save(petDtoDemapper.apply(petDto)));
    }

    public Response<Pet> update(PetDto petDto) {
        return ResponseBuilder.templateSuccess(petRepository.save(petDtoIntegrator.apply(petDto)));
    }

    public Response<Pet> deleteById(long id) {
        if (!petRepository.existsById(id)) {
            return ResponseBuilder.templateFail("Pet with id " + id + " does not exist!");
        }
        petRepository.deleteById(id);
        return ResponseBuilder.templateSuccess(null);
    }
}
