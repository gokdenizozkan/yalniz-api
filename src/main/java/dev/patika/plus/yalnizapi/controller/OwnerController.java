package dev.patika.plus.yalnizapi.controller;

import dev.patika.plus.yalnizapi.dto.owner.OwnerDto;
import dev.patika.plus.yalnizapi.entity.Owner;
import dev.patika.plus.yalnizapi.entity.Pet;
import dev.patika.plus.yalnizapi.entity.response.Response;
import dev.patika.plus.yalnizapi.service.OwnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public ResponseEntity<List<Owner>> findAll() {
        Response<List<Owner>> response = ownerService.findAll();
        return ResponseEntity
                .status(response.code())
                .body(response.data());
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public ResponseEntity<Owner> findById(@PathVariable long id) {
        Response<Owner> response = ownerService.findById(id);
        return ResponseEntity
                .status(response.code())
                .body(response.data());
    }

    @GetMapping("/search")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public ResponseEntity<List<Owner>> search(@RequestParam(value = "name") String query) {
        Response<List<Owner>> response = ownerService.search(query);
        return ResponseEntity
                .status(response.code())
                .body(response.data());
    }

    @GetMapping("/{id}/pets")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public ResponseEntity<Set<Pet>> findPetsById(@PathVariable long id) {
        Response<Set<Pet>> response = ownerService.findPetsById(id);
        return ResponseEntity
                .status(response.code())
                .body(response.data());
    }

    @PostMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.CREATED)
    public ResponseEntity<Owner> save(@RequestBody OwnerDto ownerDto) {
        Response<Owner> response = ownerService.save(ownerDto);
        return ResponseEntity
                .status(response.code())
                .body(response.data());
    }

    @PutMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.ACCEPTED)
    public ResponseEntity<Owner> update(@RequestBody OwnerDto ownerDto) {
        Response<Owner> response = ownerService.updateById(ownerDto);
        return ResponseEntity
                .status(response.code())
                .body(response.data());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.NO_CONTENT)
    public ResponseEntity<Owner> deleteById(@PathVariable long id) {
        Response<Owner> response = ownerService.deleteById(id);
        return ResponseEntity
                .status(response.code())
                .body(response.data());
    }
}
