package dev.patika.plus.yalnizapi.structures.vet;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vets")
public class VetController {
    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping
    public List<Vet> findAll() {
        return vetService.findAll();
    }

    @GetMapping("/{id}")
    public Vet findById(@PathVariable int id) {
        return vetService.findById(id);
    }


    @PostMapping
    public Vet save(@RequestBody Vet vet) {
        return vetService.save(vet);
    }

    @PutMapping("/{id}")
    public Vet update(@PathVariable int id, @RequestBody Vet vet) {
        return vetService.update(id, vet);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        vetService.deleteById(id);
    }
}
