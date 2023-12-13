package dev.patika.plus.yalnizapi.controller;

import dev.patika.plus.yalnizapi.dto.appointment.AppointmentDto;
import dev.patika.plus.yalnizapi.entity.Appointment;
import dev.patika.plus.yalnizapi.service.AppointmentService;
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
    public List<Appointment> findAll() {
        return appointmentService.findAll();
    }

    @GetMapping("/vet/{vetId}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public Set<Appointment> findAllByVetIdAndStartDateTimeBetween(@PathVariable long vetId, @RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return appointmentService.findAllByVetIdAndStartDateTimeBetween(vetId, startDate, endDate);
    }

    @GetMapping("/pet/{petId}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public Set<Appointment> findAllByPetIdAndStartDateTimeBetween(@PathVariable long petId, @RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return appointmentService.findAllByPetIdAndStartDateTimeBetween(petId, startDate, endDate);
    }

    @PostMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.CREATED)
    public Appointment save(AppointmentDto appointmentDto) {
        return appointmentService.save(appointmentDto);
    }
}
