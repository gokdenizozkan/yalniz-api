package dev.patika.plus.yalnizapi.controller;

import dev.patika.plus.yalnizapi.dto.owner.OwnerDto;
import dev.patika.plus.yalnizapi.entity.Owner;
import dev.patika.plus.yalnizapi.entity.Pet;
import dev.patika.plus.yalnizapi.entity.response.Response;
import dev.patika.plus.yalnizapi.service.OwnerService;
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
    public Response<List<Owner>> findAll() {
        return ownerService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public Response<Owner> findById(@PathVariable long id) {
        return ownerService.findById(id);
    }

    @GetMapping("/search")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public Response<List<Owner>> search(@RequestParam(value = "name") String query) {
        return ownerService.search(query);
    }

    @GetMapping("/{id}/pets")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public Response<Set<Pet>> findPetsById(@PathVariable long id) {
        return ownerService.findPetsById(id);
    }

    @PostMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.CREATED)
    public Response<Owner> save(@RequestBody OwnerDto ownerDto) {
        return ownerService.save(ownerDto);
    }

    @PutMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.ACCEPTED)
    public Response<Owner> update(@RequestBody OwnerDto ownerDto) {
        return ownerService.updateById(ownerDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.NO_CONTENT)
    public Response<Owner> deleteById(@PathVariable long id) {
        return ownerService.deleteById(id);
    }
}
