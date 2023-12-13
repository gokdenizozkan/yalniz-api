package dev.patika.plus.yalnizapi.service;

import dev.patika.plus.yalnizapi.dto.pet.PetDto;
import dev.patika.plus.yalnizapi.dto.pet.PetDtoDemapper;
import dev.patika.plus.yalnizapi.dto.pet.PetDtoIntegrator;
import dev.patika.plus.yalnizapi.entity.Pet;
import dev.patika.plus.yalnizapi.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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

    public Pet findById(long id) {
        return petRepository.findById(id).orElseThrow();
    }

    /*
        public Set<Appointment> findAnimalByIdAndRetrieveAppointments(long id) {
            return animalRepository.findById(id).orElseThrow().getAppointments();
        }

        public Set<Vaccine> findAnimalByIdAndRetrieveVaccines(long id) {
            return animalRepository.findById(id).orElseThrow().getVaccines();
        }
    */
    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    public Set<Pet> search(String query) {
        return petRepository.findByNameLikeIgnoreCase(query);
    }

    public Pet save(PetDto petDto) {
        return petRepository.save(petDtoDemapper.apply(petDto));
    }

    public void updateById(long id, PetDto petDto) {
        petRepository.save(petDtoIntegrator.apply(petDto));
    }

    public void deleteById(long id) {
        petRepository.deleteById(id);
    }


}
