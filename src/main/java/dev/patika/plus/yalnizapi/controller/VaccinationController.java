package dev.patika.plus.yalnizapi.controller;

import dev.patika.plus.yalnizapi.dto.vaccination.VaccinationDto;
import dev.patika.plus.yalnizapi.entity.Vaccination;
import dev.patika.plus.yalnizapi.entity.response.Response;
import dev.patika.plus.yalnizapi.service.VaccinationService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/vaccinations")
public class VaccinationController {
    private final VaccinationService vaccinationService;

    public VaccinationController(VaccinationService vaccinationService) {
        this.vaccinationService = vaccinationService;
    }

    @GetMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public Response<List<Vaccination>> findAll() {
        return vaccinationService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public Response<Vaccination> findById(@PathVariable long id) {
        return vaccinationService.findById(id);
    }

    @GetMapping("/ending-soon")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public Response<List<Vaccination>> findAllEndingSoon(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return vaccinationService.findAllEndingSoon(startDate, endDate);
    }

    @GetMapping("/of-pet/{petId}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public Response<List<Vaccination>> findAllByPetId(@PathVariable long petId) {
        return vaccinationService.findAllByPetId(petId);
    }

    @PostMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.CREATED)
    public Response<Vaccination> saveOfPet(@RequestBody VaccinationDto vaccinationDto) {
        return vaccinationService.save(vaccinationDto);
    }

    @PutMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.ACCEPTED)
    public Response<Vaccination> updateById(@RequestBody VaccinationDto vaccinationDto) {
        return vaccinationService.update(vaccinationDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.NO_CONTENT)
    public Response<Vaccination> deleteById(@PathVariable long id) {
        return vaccinationService.deleteById(id);
    }
}
