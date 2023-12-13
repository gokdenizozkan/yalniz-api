package dev.patika.plus.yalnizapi.controller;

import dev.patika.plus.yalnizapi.dto.owner.OwnerDto;
import dev.patika.plus.yalnizapi.entity.Owner;
import dev.patika.plus.yalnizapi.service.OwnerService;
import jakarta.websocket.server.PathParam;
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
    public List<Owner> findAll() {
        return ownerService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public Owner findById(@PathVariable long id) {
        return ownerService.findById(id);
    }

    @GetMapping("/search")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public Set<Owner> search(@PathParam(value = "name") String query) {
        return ownerService.search(query);
    }

    @PostMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.CREATED)
    public Owner save(@RequestBody OwnerDto ownerDto) {
        return ownerService.save(ownerDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.ACCEPTED)
    public void update(@PathVariable long id, @RequestBody OwnerDto ownerDto) {
        ownerService.updateById(id, ownerDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable long id) {
        ownerService.deleteById(id);
    }
}
