package dev.patika.plus.yalnizapi.controller;

import dev.patika.plus.yalnizapi.dto.pet.PetDto;
import dev.patika.plus.yalnizapi.entity.Pet;
import dev.patika.plus.yalnizapi.entity.response.Response;
import dev.patika.plus.yalnizapi.service.PetService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Pet>> findAll() {
        Response<List<Pet>> response = petService.findAll();
        return ResponseEntity
                .status(response.code())
                .body(response.data());
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public ResponseEntity<Pet> findById(@PathVariable long id) {
        Response<Pet> response = petService.findById(id);
        return ResponseEntity
                .status(response.code())
                .body(response.data());
    }

    @GetMapping("/search")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public ResponseEntity<List<Pet>> search(@RequestParam(value = "name") String query) {
        Response<List<Pet>> response = petService.search(query);
        return ResponseEntity
                .status(response.code())
                .body(response.data());
    }

    @PostMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.CREATED)
    public ResponseEntity<Pet> save(@RequestBody PetDto petDto) {
        Response<Pet> response = petService.save(petDto);
        return ResponseEntity
                .status(response.code())
                .body(response.data());
    }

    @PutMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.ACCEPTED)
    public ResponseEntity<Pet> update(@RequestBody PetDto petDto) {
        Response<Pet> response = petService.update(petDto);
        return ResponseEntity
                .status(response.code())
                .body(response.data());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.NO_CONTENT)
    public ResponseEntity<Pet> deleteById(@PathVariable long id) {
        Response<Pet> response = petService.deleteById(id);
        return ResponseEntity
                .status(response.code())
                .body(response.data());
    }
}
