package dev.patika.plus.yalnizapi.controller;

import dev.patika.plus.yalnizapi.dto.pet.PetDto;
import dev.patika.plus.yalnizapi.entity.Pet;
import dev.patika.plus.yalnizapi.service.PetService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public List<Pet> findAll() {
        return petService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public Pet findById(@PathVariable long id) {
        return petService.findById(id);
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
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public Set<Pet> search(@PathParam(value = "name") String query) {
        return petService.search(query);
    }

    @PostMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.CREATED)
    public Pet save(@RequestBody PetDto petDto) {
        return petService.save(petDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.ACCEPTED)
    public void update(@PathVariable long id, @RequestBody PetDto petDto) {
        petService.updateById(id, petDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable long id) {
        petService.deleteById(id);
    }


}
