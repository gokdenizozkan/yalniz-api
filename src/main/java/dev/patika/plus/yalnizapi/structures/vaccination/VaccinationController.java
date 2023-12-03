package dev.patika.plus.yalnizapi.structures.vaccination;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/vaccines")
public class VaccinationController {
    private final VaccinationService vaccinationService;

    public VaccinationController(VaccinationService vaccinationService) {
        this.vaccinationService = vaccinationService;
    }

    @GetMapping
    public List<Vaccination> findAll() {
        return vaccinationService.findAll();
    }

    @GetMapping("/ending-soon")
    public List<Vaccination> findAllEndingSoon(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return vaccinationService.findAllEndingSoon(startDate, endDate);
    }

    @GetMapping("/of-animal/{animalId}")
    public List<Vaccination> findAllByAnimalId(@PathVariable long animalId) {
        return vaccinationService.findAllByAnimalId(animalId);
    }

    @GetMapping("/{id}")
    public Vaccination findById(@PathVariable long id) {
        return vaccinationService.findById(id);
    }

    @PostMapping("/{id}")
    public void updateById(@PathVariable long id, @RequestBody Vaccination vaccination) {
        vaccinationService.updateById(id, vaccination);
    }

    @PostMapping(path = "/of-animal/{animalId}")
    public Vaccination saveOfAnimal(@PathVariable long animalId, @RequestBody Vaccination vaccination) {
        return vaccinationService.saveByAnimalId(animalId, vaccination);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        vaccinationService.deleteById(id);
    }


}
