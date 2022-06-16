package com.clinic.controllers;

import com.clinic.models.Appointment;
import com.clinic.services.AppointmentService;
import com.clinic.services.DoctorService;
import com.clinic.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @Autowired
    DoctorService doctorService;

    @Autowired
    PatientService patientService;


    @GetMapping("")
    public List<Appointment> listAppointment() {
        return appointmentService.listAllAppointment();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> get(@PathVariable Integer id) {
        try {
            Appointment appointment = appointmentService.getAppointment(id);
            return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void add(@RequestBody Appointment appointment) {
        appointmentService.saveAppointment(appointment);
    }

    @PostMapping("/add")
    public void addAppointment(
            @RequestParam LocalDate appointmentDate,
            @RequestParam int doctorId,
            @RequestParam int patientId) {
        Appointment newAppointment = new Appointment();
        newAppointment.setAppointmentDate(appointmentDate);
        newAppointment.setPatientId(patientService.getPatient(patientId));
        newAppointment.setDoctorId(doctorService.getDoctor(doctorId));
        appointmentService.saveAppointment(newAppointment);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Appointment appointment, @PathVariable Integer appointment_id) {
        try {
            Appointment existAppointment = appointmentService.getAppointment(appointment_id);
            appointment.setAppointmentId(appointment_id);
            appointmentService.saveAppointment(appointment);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer appointment_id) {

        appointmentService.deleteAppointment(appointment_id);
    }
}