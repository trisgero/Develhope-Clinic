package com.clinic.controllers;

import com.clinic.models.Appointment;
import com.clinic.services.AppointmentService;
import com.clinic.services.DoctorService;
import com.clinic.services.PatientService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
    @ApiOperation(value = "Function that returns all appointments", notes = "returns all Appointments present in the DB")
    public List<Appointment> listAppointment() {
        return appointmentService.listAllAppointment();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Function that returns doctor by appointmentId", notes = "returns a Appointment from appointment_Id")
    public ResponseEntity<Appointment> get(@PathVariable Integer id) {
        try {
            Appointment appointment = appointmentService.getAppointment(id);
            return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
        }
    }

//    @PostMapping("")
//    public void add(@RequestBody Appointment appointment) {
//        appointmentService.saveAppointment(appointment);
//    }

    @PostMapping("/add")
    @ApiOperation(value = "Function that inserts a single appointment")
    public void addAppointment(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate appointmentDate,
            @RequestParam int doctorId,
            @RequestParam int patientId) {
        Appointment newAppointment = new Appointment();
        newAppointment.setAppointmentDate(appointmentDate);
        newAppointment.setPatientId(patientService.getPatient(patientId));
        newAppointment.setDoctorId(doctorService.getDoctor(doctorId));
        appointmentService.saveAppointment(newAppointment);
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "Function that deletes a single appointment")
    public void delete(@PathVariable Integer appointment_id) {
        appointmentService.deleteAppointment(appointment_id);
    }
}