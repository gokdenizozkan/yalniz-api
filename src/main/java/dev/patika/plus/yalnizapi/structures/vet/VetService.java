package dev.patika.plus.yalnizapi.structures.vet;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VetService {
    private final VetRepository vetRepository;

    public VetService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }

    public List<Vet> findAll() {
        return vetRepository.findAll();
    }

    public Vet findById(int id) {
        return vetRepository.findById(id).orElseThrow();
    }

    public void deleteById(int id) {
        vetRepository.deleteById(id);
    }

    public Vet update(int id, Vet vet) {
        vetRepository.findById(id).orElseThrow();

        vet.setId(id);
        return save(vet);
    }
}
