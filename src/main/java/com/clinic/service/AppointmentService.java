package com.clinic.service;

import com.clinic.model.Appointment;
import com.clinic.model.Patient;
import com.clinic.repository.AppointmentRepository;
import com.clinic.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> listAllAppointment() {
        return appointmentRepository.findAll();
    }

    public void saveAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    public Appointment getAppointment(Integer id) {
        return appointmentRepository.findById(id).get();
    }

    public void deleteAppointment(Integer id) {
        appointmentRepository.deleteById(id);
    }

}

