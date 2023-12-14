package dev.patika.plus.yalnizapi.controller;

import dev.patika.plus.yalnizapi.dto.vaccination.VaccinationDto;
import dev.patika.plus.yalnizapi.entity.Vaccination;
import dev.patika.plus.yalnizapi.entity.response.Response;
import dev.patika.plus.yalnizapi.service.VaccinationService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Vaccination>> findAll() {
        Response<List<Vaccination>> response = vaccinationService.findAll();
        return ResponseEntity
                .status(response.code())
                .body(response.data());
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public ResponseEntity<Vaccination> findById(@PathVariable long id) {
        Response<Vaccination> response = vaccinationService.findById(id);
        return ResponseEntity
                .status(response.code())
                .body(response.data());
    }

    @GetMapping("/ending-soon")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public ResponseEntity<List<Vaccination>> findAllEndingSoon(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        Response<List<Vaccination>> response = vaccinationService.findAllEndingSoon(startDate, endDate);
        return ResponseEntity
                .status(response.code())
                .body(response.data());
    }

    @GetMapping("/of-pet/{petId}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public ResponseEntity<List<Vaccination>> findAllByPetId(@PathVariable long petId) {
        Response<List<Vaccination>> response = vaccinationService.findAllByPetId(petId);
        return ResponseEntity
                .status(response.code())
                .body(response.data());
    }

    @PostMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.CREATED)
    public ResponseEntity<Vaccination> saveOfPet(@RequestBody VaccinationDto vaccinationDto) {
        Response<Vaccination> response = vaccinationService.save(vaccinationDto);
        return ResponseEntity
                .status(response.code())
                .body(response.data());
    }

    @PutMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.ACCEPTED)
    public ResponseEntity<Vaccination> updateById(@RequestBody VaccinationDto vaccinationDto) {
        Response<Vaccination> response = vaccinationService.update(vaccinationDto);
        return ResponseEntity
                .status(response.code())
                .body(response.data());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.NO_CONTENT)
    public ResponseEntity<Vaccination> deleteById(@PathVariable long id) {
        Response<Vaccination> response = vaccinationService.deleteById(id);
        return ResponseEntity
                .status(response.code())
                .body(response.data());
    }


}
