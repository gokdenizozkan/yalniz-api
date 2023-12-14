package dev.patika.plus.yalnizapi.controller;

import dev.patika.plus.yalnizapi.dto.pet.PetDto;
import dev.patika.plus.yalnizapi.entity.Pet;
import dev.patika.plus.yalnizapi.entity.response.Response;
import dev.patika.plus.yalnizapi.service.PetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public Response<List<Pet>> findAll() {
        return petService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public Response<Pet> findById(@PathVariable long id) {
        return petService.findById(id);
    }

    @GetMapping("/search")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public Response<List<Pet>> search(@RequestParam(value = "name") String query) {
        return petService.search(query);
    }

    @PostMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.CREATED)
    public Response<Pet> save(@RequestBody PetDto petDto) {
        return petService.save(petDto);
    }

    @PutMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.ACCEPTED)
    public Response<Pet> update(@RequestBody PetDto petDto) {
        return petService.update(petDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.NO_CONTENT)
    public Response<Pet> deleteById(@PathVariable long id) {
        return petService.deleteById(id);
    }
}
