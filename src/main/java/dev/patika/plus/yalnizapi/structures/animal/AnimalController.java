package dev.patika.plus.yalnizapi.structures.animal;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public List<Animal> findAll() {
        return animalService.findAll();
    }

    @GetMapping("/{id}")
    public Animal findById(@PathVariable long id) {
        return animalService.findById(id);
    }

    /*
        @GetMapping("/{id}/appointments")
        public Set<Appointment> findAnimalByIdAndRetrieveAppointments(@PathVariable long id) {
            return animalService.findAnimalByIdAndRetrieveAppointments(id);
        }

        @GetMapping("/{id}/vaccines")
        public Set<Vaccine> findAnimalByIdAndRetrieveVaccines(@PathVariable long id) {
            return animalService.findAnimalByIdAndRetrieveVaccines(id);
        }
    */
    @GetMapping("/search")
    public Set<Animal> search(@PathParam(value = "name") String query) {
        return animalService.search(query);
    }

    @PostMapping
    public Animal save(@RequestBody Animal animal) {
        return animalService.save(animal);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody Animal animal) {
        animalService.updateById(id, animal);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        animalService.deleteById(id);
    }


}
