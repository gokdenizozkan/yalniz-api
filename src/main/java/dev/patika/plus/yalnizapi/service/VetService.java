package dev.patika.plus.yalnizapi.service;

import dev.patika.plus.yalnizapi.dto.vet.VetDto;
import dev.patika.plus.yalnizapi.dto.vet.VetDtoDemapper;
import dev.patika.plus.yalnizapi.dto.vet.VetDtoIntegrator;
import dev.patika.plus.yalnizapi.dto.vet.VetDtoMapper;
import dev.patika.plus.yalnizapi.entity.Vet;
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

    public List<Vet> findAll() {
        return vetRepository.findAll();
    }

    public Vet findById(Long id) {
        return vetRepository.findById(id).orElseThrow();
    }

    public Vet save(VetDto vetDto) {
        return vetRepository.save(vetDtoDemapper.apply(vetDto));
    }

    public Vet update(Long id, VetDto vetDto) {
        return vetRepository.save(vetDtoIntegrator.apply(vetDto));
    }

    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
