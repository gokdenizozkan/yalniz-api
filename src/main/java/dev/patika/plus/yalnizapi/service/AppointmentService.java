package dev.patika.plus.yalnizapi.service;

import dev.patika.plus.yalnizapi.dto.appointment.AppointmentDto;
import dev.patika.plus.yalnizapi.dto.appointment.AppointmentDtoDemapper;
import dev.patika.plus.yalnizapi.dto.appointment.AppointmentDtoIntegrator;
import dev.patika.plus.yalnizapi.entity.Appointment;
import dev.patika.plus.yalnizapi.entity.response.Response;
import dev.patika.plus.yalnizapi.entity.response.ResponseBuilder;
import dev.patika.plus.yalnizapi.repository.AppointmentRepository;
import dev.patika.plus.yalnizapi.repository.WorkdayRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentDtoDemapper appointmentDtoDemapper;
    private final AppointmentDtoIntegrator appointmentDtoIntegrator;
    private final WorkdayRepository workdayRepository;

    public AppointmentService(AppointmentRepository appointmentRepository, AppointmentDtoDemapper appointmentDtoDemapper, AppointmentDtoIntegrator appointmentDtoIntegrator, WorkdayRepository workdayRepository) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentDtoDemapper = appointmentDtoDemapper;
        this.appointmentDtoIntegrator = appointmentDtoIntegrator;
        this.workdayRepository = workdayRepository;
    }

    public Response<Appointment> save(AppointmentDto appointmentDto) {
        Long vetId = appointmentDto.vetId();
        LocalDateTime startDateTime = appointmentDto.startDateTime();
        boolean vetNotWorking = !workdayRepository.existsByVet_IdAndDate(vetId, startDateTime.toLocalDate());
        if (vetNotWorking) return ResponseBuilder.templateFail("Vet is not working on " + startDateTime.toLocalDate());

        boolean vetNotAvailable = appointmentRepository.existsByVet_IdAndStartDateTimeBetween(vetId, startDateTime, startDateTime.plusHours(1));
        if (vetNotAvailable)
            return ResponseBuilder.templateFail("Vet is not available between " + startDateTime + " and " + startDateTime.plusHours(1));

        return ResponseBuilder.templateSuccess(appointmentRepository.save(appointmentDtoDemapper.apply(appointmentDto)));
    }

    public Response<Appointment> findById(long id) {
        Appointment appointment = appointmentRepository.findById(id).orElse(null);
        if (appointment == null) return ResponseBuilder.templateFail("Appointment not found");
        else return ResponseBuilder.templateSuccess(appointment);
    }

    public Response<Appointment> updateById(long id, AppointmentDto appointmentDto) {
        Appointment appointment = appointmentDtoIntegrator.apply(appointmentDto);
        return ResponseBuilder.templateSuccess(appointmentRepository.save(appointment));
    }

    public Response<Appointment> deleteById(long id) {
        if (!appointmentRepository.existsById(id)) {
            return ResponseBuilder.templateFail("Appointment with id " + id + " does not exist!");
        }
        appointmentRepository.deleteById(id);
        return ResponseBuilder.templateSuccess(null);
    }

    public Response<List<Appointment>> findAll() {
        return ResponseBuilder.templateSuccess(appointmentRepository.findAll());
    }

    public Response<Set<Appointment>> findAllByVetIdAndStartDateTimeBetween(long vetId, LocalDate startDate, LocalDate endDate) {
        LocalDateTime startLocalDateTime = LocalDateTime.of(startDate, LocalTime.of(0, 0));
        LocalDateTime endLocalDateTime = LocalDateTime.of(endDate, LocalTime.of(23, 59));
        return ResponseBuilder.templateSuccess(appointmentRepository.findAllByVetIdAndStartDateTimeBetween(vetId, startLocalDateTime, endLocalDateTime));
    }

    public Response<Set<Appointment>> findAllByPetIdAndStartDateTimeBetween(long petId, LocalDate startDate, LocalDate endDate) {
        LocalDateTime startLocalDateTime = LocalDateTime.of(startDate, LocalTime.of(0, 0));
        LocalDateTime endLocalDateTime = LocalDateTime.of(endDate, LocalTime.of(23, 59));
        return ResponseBuilder.templateSuccess(appointmentRepository.findAllByPetIdAndStartDateTimeBetween(petId, startLocalDateTime, endLocalDateTime));
    }
}
