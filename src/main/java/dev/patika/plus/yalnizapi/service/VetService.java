package dev.patika.plus.yalnizapi.service;

import dev.patika.plus.yalnizapi.dto.vet.VetDto;
import dev.patika.plus.yalnizapi.dto.vet.VetDtoDemapper;
import dev.patika.plus.yalnizapi.dto.vet.VetDtoIntegrator;
import dev.patika.plus.yalnizapi.dto.vet.VetDtoMapper;
import dev.patika.plus.yalnizapi.entity.Vet;
import dev.patika.plus.yalnizapi.entity.response.Response;
import dev.patika.plus.yalnizapi.entity.response.ResponseBuilder;
import dev.patika.plus.yalnizapi.repository.VetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VetService {
    private final VetRepository vetRepository;
    private final VetDtoMapper vetDtoMapper;
    private final VetDtoIntegrator vetDtoIntegrator;
    private final VetDtoDemapper vetDtoDemapper;

    public VetService(VetRepository vetRepository, VetDtoMapper vetDtoMapper, VetDtoIntegrator vetDtoIntegrator, VetDtoDemapper vetDtoDemapper) {
        this.vetRepository = vetRepository;
        this.vetDtoMapper = vetDtoMapper;
        this.vetDtoIntegrator = vetDtoIntegrator;
        this.vetDtoDemapper = vetDtoDemapper;
    }

    public Response<List<Vet>> findAll() {
        return ResponseBuilder.templateSuccess(vetRepository.findAll());
    }

    public Response<Vet> findById(Long id) {
        return ResponseBuilder.auto(vetRepository.findById(id).orElse(null));
    }

    public Response<Vet> save(VetDto vetDto) {
        return ResponseBuilder.templateSuccess(vetRepository.save(vetDtoDemapper.apply(vetDto)));
    }

    public Response<Vet> update(VetDto vetDto) {
        return ResponseBuilder.templateSuccess(vetRepository.save(vetDtoIntegrator.apply(vetDto)));
    }

    public Response<Vet> deleteById(Long id) {
        if (!vetRepository.existsById(id)) {
            return ResponseBuilder.templateFail("Vet with id " + id + " does not exist!");
        }
        vetRepository.deleteById(id);
        return ResponseBuilder.templateSuccess(null);
    }
}
