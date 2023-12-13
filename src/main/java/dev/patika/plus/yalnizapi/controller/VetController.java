package dev.patika.plus.yalnizapi.controller;

import dev.patika.plus.yalnizapi.dto.vet.VetDto;
import dev.patika.plus.yalnizapi.entity.Vet;
import dev.patika.plus.yalnizapi.service.VetService;
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
    public List<Vet> findAll() {
        return vetService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public Vet findById(@PathVariable Long id) {
        return vetService.findById(id);
    }


    @PostMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.CREATED)
    public Vet save(@RequestBody VetDto vetDto) {
        return vetService.save(vetDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.ACCEPTED)
    public Vet update(@PathVariable Long id, @RequestBody VetDto vetDto) {
        return vetService.update(id, vetDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        vetService.deleteById(id);
    }
}
