package dev.patika.plus.yalnizapi.controller;

import dev.patika.plus.yalnizapi.dto.vet.VetDto;
import dev.patika.plus.yalnizapi.entity.Vet;
import dev.patika.plus.yalnizapi.entity.response.Response;
import dev.patika.plus.yalnizapi.service.VetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vets")
public class VetController {
    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public ResponseEntity<List<Vet>> findAll() {
        Response<List<Vet>> response = vetService.findAll();
        return ResponseEntity.status(response.code()).body(response.data());
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public ResponseEntity<Vet> findById(@PathVariable Long id) {
        Response<Vet> response = vetService.findById(id);
        return ResponseEntity.status(response.code()).body(response.data());
    }


    @PostMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.CREATED)
    public ResponseEntity<Vet> save(@RequestBody VetDto vetDto) {
        Response<Vet> response = vetService.save(vetDto);
        return ResponseEntity.status(response.code()).body(response.data());
    }

    @PutMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.ACCEPTED)
    public ResponseEntity<Vet> update(@RequestBody VetDto vetDto) {
        Response<Vet> response = vetService.update(vetDto);
        return ResponseEntity.status(response.code()).body(response.data());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.NO_CONTENT)
    public ResponseEntity<Vet> deleteById(@PathVariable Long id) {
        Response<Vet> response = vetService.deleteById(id);
        return ResponseEntity.status(response.code()).body(response.data());
    }
}
