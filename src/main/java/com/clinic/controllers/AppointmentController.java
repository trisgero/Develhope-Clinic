package com.clinic.controllers;

import com.clinic.models.Appointment;
import com.clinic.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @GetMapping("")
    public List<Appointment> listAppointment(){
        return appointmentService.listAllAppointment();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> get(@PathVariable Integer appointment_id) {
        try {
            Appointment appointment = appointmentService.getAppointment(appointment_id);
            return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Appointment appointment) {
        appointmentService.saveAppointment(appointment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Appointment appointment, @PathVariable Integer appointment_id) {
        try {
            Appointment existAppointment = appointmentService.getAppointment(appointment_id);
            appointment.setAppointment_id(appointment_id);
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
