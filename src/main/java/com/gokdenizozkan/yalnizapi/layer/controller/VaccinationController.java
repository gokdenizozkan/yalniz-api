package com.gokdenizozkan.yalnizapi.layer.controller;

import com.gokdenizozkan.yalnizapi.config.response.StructuredResponse;
import com.gokdenizozkan.yalnizapi.dto.vaccination.request.VaccinationSaveRequest;
import com.gokdenizozkan.yalnizapi.dto.vaccination.request.VaccinationUpdateRequest;
import com.gokdenizozkan.yalnizapi.layer.responser.VaccinationResponser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v2/vaccinations")
@RequiredArgsConstructor
public class VaccinationController {
    private final VaccinationResponser responser;

    @GetMapping
    public ResponseEntity<StructuredResponse> findAll() {
        return responser.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StructuredResponse> findById(@PathVariable Long id) {
        return responser.findById(id);
    }

    @GetMapping("/of-pet/{petId}")
    public ResponseEntity<StructuredResponse> findAllByPetId(@PathVariable Long petId) {
        return responser.findAllByPetId(petId);
    }

    @GetMapping("/ending-soon")
    public ResponseEntity<StructuredResponse> findAllEndingSoon(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return responser.findAllEndingSoon(startDate, endDate);
    }

    @PostMapping("/of-pet/{petId}")
    public ResponseEntity<StructuredResponse> saveForPet(@PathVariable Long petId, @RequestBody VaccinationSaveRequest request) {
        return responser.saveForPet(petId, request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StructuredResponse> update(@PathVariable Long id, @RequestBody VaccinationUpdateRequest request) {
        return responser.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StructuredResponse> deleteById(@PathVariable Long id) {
        return responser.deleteById(id);
    }
}
