package dev.patika.plus.yalnizapi.structures.animal;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal save(Animal animal) {
        return animalRepository.save(animal);
    }

    public Animal findById(long id) {
        return animalRepository.findById(id).orElseThrow();
    }

    /*
        public Set<Appointment> findAnimalByIdAndRetrieveAppointments(long id) {
            return animalRepository.findById(id).orElseThrow().getAppointments();
        }

        public Set<Vaccine> findAnimalByIdAndRetrieveVaccines(long id) {
            return animalRepository.findById(id).orElseThrow().getVaccines();
        }
    */
    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    public Set<Animal> search(String query) {
        return animalRepository.findByNameLikeIgnoreCase(query);
    }

    public void updateById(long id, Animal animal) {
        if (animalRepository.existsById(id)) {
            animal.setId(id);
            animalRepository.save(animal);
        }
    }

    public void deleteById(long id) {
        animalRepository.deleteById(id);
    }


}
