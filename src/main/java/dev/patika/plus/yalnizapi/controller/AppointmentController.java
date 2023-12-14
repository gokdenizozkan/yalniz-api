package dev.patika.plus.yalnizapi.controller;

import dev.patika.plus.yalnizapi.dto.appointment.AppointmentDto;
import dev.patika.plus.yalnizapi.entity.Appointment;
import dev.patika.plus.yalnizapi.entity.response.Response;
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
    public Response<List<Appointment>> findAll() {
        return appointmentService.findAll();
    }

    @GetMapping("/vet/{vetId}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public Response<Set<Appointment>> findAllByVetIdAndStartDateTimeBetween(@PathVariable long vetId, @RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return appointmentService.findAllByVetIdAndStartDateTimeBetween(vetId, startDate, endDate);
    }

    @GetMapping("/pet/{petId}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public Response<Set<Appointment>> findAllByPetIdAndStartDateTimeBetween(@PathVariable long petId, @RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return appointmentService.findAllByPetIdAndStartDateTimeBetween(petId, startDate, endDate);
    }

    @PutMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.ACCEPTED)
    public Response<Appointment> update(@RequestBody AppointmentDto appointmentDto) {
        return appointmentService.update(appointmentDto);
    }

    @PostMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.CREATED)
    public Response<Appointment> save(@RequestBody AppointmentDto appointmentDto) {
        return appointmentService.save(appointmentDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.NO_CONTENT)
    public Response<Appointment> deleteById(@PathVariable long id) {
        return appointmentService.deleteById(id);
    }
}
