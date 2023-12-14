package dev.patika.plus.yalnizapi.controller;

import dev.patika.plus.yalnizapi.dto.appointment.AppointmentDto;
import dev.patika.plus.yalnizapi.entity.Appointment;
import dev.patika.plus.yalnizapi.entity.response.Response;
import dev.patika.plus.yalnizapi.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public ResponseEntity<List<Appointment>> findAll() {
        Response<List<Appointment>> response = appointmentService.findAll();
        return ResponseEntity
                .status(response.code())
                .body(response.data());
    }

    @GetMapping("/vet/{vetId}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public ResponseEntity<Set<Appointment>> findAllByVetIdAndStartDateTimeBetween(@PathVariable long vetId, @RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        Response<Set<Appointment>> response = appointmentService.findAllByVetIdAndStartDateTimeBetween(vetId, startDate, endDate);
        return ResponseEntity
                .status(response.code())
                .body(response.data());
    }

    @GetMapping("/pet/{petId}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public ResponseEntity<Set<Appointment>> findAllByPetIdAndStartDateTimeBetween(@PathVariable long petId, @RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        Response<Set<Appointment>> response = appointmentService.findAllByPetIdAndStartDateTimeBetween(petId, startDate, endDate);
        return ResponseEntity
                .status(response.code())
                .body(response.data());
    }

    @PostMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.CREATED)
    public ResponseEntity<Appointment> save(@RequestBody AppointmentDto appointmentDto) {
        Response<Appointment> response = appointmentService.save(appointmentDto);
        return ResponseEntity
                .status(response.code())
                .body(response.data());
    }

    // TODO put and delete mappings
}
