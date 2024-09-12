package com.example.finalproject.Service;

import com.example.finalproject.Model.Appointment;
import com.example.finalproject.Repository.AppointmentRepository;
import com.example.finalproject.Api.ApiException;
import com.example.finalproject.Model.Requests;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;


    public List<Appointment> getAppointment() {
        return appointmentRepository.findAll();
    }

    public void addAppointment( Integer AppointmentId, Appointment appointment) {
        Appointment appointment1 = appointmentRepository.findAppointmentByAppointmentId(AppointmentId);
        if (appointment1 == null) {
            throw new ApiException("Id not found");
        }
        appointmentRepository.save(appointment);
    }
    public void updateAppointment(Integer id, Appointment appointment) {
        Appointment appointment1 = appointmentRepository.findAppointmentByAppointmentId(id);
        if (appointment1 == null) {
            throw new ApiException("id not found");
        }
        appointment1.setAppointmentDate(appointment.getAppointmentDate());
        appointment1.setAppointmentReason(appointment.getAppointmentReason());
        appointment1.setAppointmentType(appointment.getAppointmentType());
        appointment1.setCompleted(appointment.isCompleted());
        appointment1.setStatus(appointment.getStatus());
        appointment1.setDoctor(appointment.getDoctor());
        appointment1.setMedicalHistory(appointment.getMedicalHistory());

        appointmentRepository.save(appointment1);

    }

    public void deleteAppointment(Integer id) {
        Appointment appointment1 = appointmentRepository.findAppointmentByAppointmentId(id);
        if (appointment1 == null) {
            throw new ApiException("id not found");
        }
        appointmentRepository.delete(appointment1);
    }

}
