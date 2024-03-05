package com.gokdenizozkan.yalnizapi.layer.controller;

import com.gokdenizozkan.yalnizapi.config.response.StructuredResponse;
import com.gokdenizozkan.yalnizapi.dto.appointment.request.AppointmentSaveRequest;
import com.gokdenizozkan.yalnizapi.dto.appointment.request.AppointmentUpdateRequest;
import com.gokdenizozkan.yalnizapi.layer.responser.AppointmentResponser;
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

@RestController
@RequestMapping("/api/v2/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentResponser responser;

    @GetMapping
    public ResponseEntity<StructuredResponse> findAll() {
        return responser.findAll();
    }

    @GetMapping("/of-vet/{vetId}")
    public ResponseEntity<StructuredResponse> findAllByVetIdAndStartDateTimeBetween(@PathVariable Long vetId, @RequestParam String startDate, @RequestParam String endDate) {
        return responser.findAllByVetIdAndStartBetween(vetId, startDate, endDate);
    }

    @GetMapping("/of-pet/{petId}")
    public ResponseEntity<StructuredResponse> findAllByPetIdAndStartDateTimeBetween(@PathVariable Long petId, @RequestParam String startDate, @RequestParam String endDate) {
        return responser.findAllByPetIdAndStartBetween(petId, startDate, endDate);
    }

    @PostMapping
    public ResponseEntity<StructuredResponse> save(@RequestBody AppointmentSaveRequest request) {
        return responser.save(request);
    }

    @PutMapping
    public ResponseEntity<StructuredResponse> update(@RequestBody AppointmentUpdateRequest request) {
        return responser.update(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StructuredResponse> deleteById(@PathVariable Long id) {
        return responser.deleteById(id);
    }
}
