package dev.patika.plus.yalnizapi.structures.appointment;

import dev.patika.plus.yalnizapi.structures.workday.Workday;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment save(Appointment appointment) {
        // Check if vet is working on the appointment day
        Set<Workday> workdays = appointment.getVet().getWorkdays();
        LocalDate appointmentDay = appointment.getStartDateTime().toLocalDate();


        boolean vetNotWorking = true;
        for (Workday workday : workdays) {
            LocalDate date = workday.getDate();
            if (date.equals(appointmentDay)) {
                vetNotWorking = false;
                break;
            }
        }
        if (vetNotWorking) throw new RuntimeException("Vet is not working on " + appointmentDay);

        // Check if vet is available on the appointment time
        LocalTime appointmentTime = appointment.getStartDateTime().toLocalTime();
        Set<Appointment> appointmentsOfVet = appointment.getVet().getAppointments();

        boolean vetAvailable = false;
        for (Appointment appointmentOfVet : appointmentsOfVet) {
            LocalTime startTime = appointmentOfVet.getStartDateTime().toLocalTime(); // 05:00
            LocalTime endTime = startTime.plusHours(1); // 06:00
            if (startTime.isBefore(appointmentTime) && endTime.isAfter(appointmentTime)) { // 05:00 < 05:30 < 06:00
                vetAvailable = true;
                break;
            }
        }
        if (!vetAvailable) throw new RuntimeException("Vet is not available on " + appointmentTime);

        return appointmentRepository.save(appointment);
    }

    public Appointment findById(long id) {
        return appointmentRepository.findById(id).orElseThrow();
    }

    public void updateById(long id, Appointment appointment) {
        if (appointmentRepository.existsById(id)) {
            appointment.setId(id);
            appointmentRepository.save(appointment);
        }
    }

    public void deleteById(long id) {
        appointmentRepository.deleteById(id);
    }

    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    public Set<Appointment> findAllByVetIdAndStartDateTimeBetween(long vetId, LocalDate startDate, LocalDate endDate) {
        LocalDateTime startLocalDateTime = LocalDateTime.of(startDate, LocalTime.of(0, 0));
        LocalDateTime endLocalDateTime = LocalDateTime.of(endDate, LocalTime.of(23, 59));
        return appointmentRepository.findAllByVetIdAndStartDateTimeBetween(vetId, startLocalDateTime, endLocalDateTime);
    }

    public Set<Appointment> findAllByAnimalIdAndStartDateTimeBetween(long animalId, LocalDate startDate, LocalDate endDate) {
        LocalDateTime startLocalDateTime = LocalDateTime.of(startDate, LocalTime.of(0, 0));
        LocalDateTime endLocalDateTime = LocalDateTime.of(endDate, LocalTime.of(23, 59));
        return appointmentRepository.findAllByAnimalIdAndStartDateTimeBetween(animalId, startLocalDateTime, endLocalDateTime);
    }
}
