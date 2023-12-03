package dev.patika.plus.yalnizapi.structures.appointment;

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

    @GetMapping
    public List<Appointment> findAll() {
        return appointmentService.findAll();
    }

    @GetMapping("/vet/{vetId}")
    public Set<Appointment> findAllByVetIdAndStartDateTimeBetween(@PathVariable long vetId, @RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return appointmentService.findAllByVetIdAndStartDateTimeBetween(vetId, startDate, endDate);
    }

    @GetMapping("/animal/{animalId}")
    public Set<Appointment> findAllByAnimalIdAndStartDateTimeBetween(@PathVariable long animalId, @RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return appointmentService.findAllByAnimalIdAndStartDateTimeBetween(animalId, startDate, endDate);
    }

    @PostMapping
    public Appointment save(Appointment appointment) {
        return appointmentService.save(appointment);
    }
}
