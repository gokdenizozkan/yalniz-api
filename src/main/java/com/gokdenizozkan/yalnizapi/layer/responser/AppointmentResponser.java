package com.gokdenizozkan.yalnizapi.layer.responser;

import com.gokdenizozkan.yalnizapi.config.response.Data;
import com.gokdenizozkan.yalnizapi.config.response.StructuredResponse;
import com.gokdenizozkan.yalnizapi.config.response.StructuredResponseEntityBuilder;
import com.gokdenizozkan.yalnizapi.dto.appointment.AppointmentDtoMappers;
import com.gokdenizozkan.yalnizapi.dto.appointment.request.AppointmentSaveRequest;
import com.gokdenizozkan.yalnizapi.dto.appointment.request.AppointmentUpdateRequest;
import com.gokdenizozkan.yalnizapi.dto.appointment.response.AppointmentResponse;
import com.gokdenizozkan.yalnizapi.entity.Appointment;
import com.gokdenizozkan.yalnizapi.layer.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AppointmentResponser {
    private final AppointmentService service;
    private final AppointmentDtoMappers dtoMappers;

    public ResponseEntity<StructuredResponse> findAll() {
        List<Appointment> appointments = service.findAll();

        List<AppointmentResponse> appointmentResponses = appointments.stream().map(dtoMappers.toResponse).toList();
        return StructuredResponseEntityBuilder.success(appointmentResponses);
    }

    public ResponseEntity<StructuredResponse> findAllByVetIdAndStartBetween(Long vetId, String startDate, String endDate) {
        List<Appointment> appointments = service.findAllByVetIdAndStartBetween(vetId, startDate, endDate);

        List<AppointmentResponse> appointmentResponses = appointments.stream().map(dtoMappers.toResponse).toList();
        return StructuredResponseEntityBuilder.success(appointmentResponses);
    }

    public ResponseEntity<StructuredResponse> findAllByPetIdAndStartBetween(Long petId, String startDate, String endDate) {
        List<Appointment> appointments = service.findAllByPetIdAndStartBetween(petId, startDate, endDate);

        List<AppointmentResponse> appointmentResponses = appointments.stream().map(dtoMappers.toResponse).toList();
        return StructuredResponseEntityBuilder.success(appointmentResponses);
    }

    public ResponseEntity<StructuredResponse> update(AppointmentUpdateRequest request) {
        Data data = service.update(request);
        data.map(dtoMappers.toResponse);
        return StructuredResponseEntityBuilder.success(data);
    }

    public ResponseEntity<StructuredResponse> save(AppointmentSaveRequest request) {
        Appointment appointment = service.save(request);
        return StructuredResponseEntityBuilder.success(dtoMappers.toResponse.apply(appointment));
    }

    public ResponseEntity<StructuredResponse> deleteById(Long id) {
        service.deleteById(id);
        return StructuredResponseEntityBuilder.success();
    }
}
