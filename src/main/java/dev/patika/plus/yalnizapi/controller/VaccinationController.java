package dev.patika.plus.yalnizapi.controller;

import dev.patika.plus.yalnizapi.dto.vaccination.VaccinationDto;
import dev.patika.plus.yalnizapi.entity.Vaccination;
import dev.patika.plus.yalnizapi.service.VaccinationService;
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

    @GetMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public List<Vaccination> findAll() {
        return vaccinationService.findAll();
    }

    @GetMapping("/ending-soon")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public List<Vaccination> findAllEndingSoon(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return vaccinationService.findAllEndingSoon(startDate, endDate);
    }

    @GetMapping("/of-pet/{petId}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public List<Vaccination> findAllByPetId(@PathVariable long petId) {
        return vaccinationService.findAllByPetId(petId);
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public Vaccination findById(@PathVariable long id) {
        return vaccinationService.findById(id);
    }


    @PostMapping("/of-pet/{petId}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.CREATED)
    public Vaccination saveOfPet(@PathVariable long petId, @RequestBody VaccinationDto vaccinationDto) {
        return vaccinationService.saveByPetId(petId, vaccinationDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.ACCEPTED)
    public void updateById(@PathVariable long id, @RequestBody VaccinationDto vaccinationDto) {
        vaccinationService.updateById(id, vaccinationDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable long id) {
        vaccinationService.deleteById(id);
    }


}
