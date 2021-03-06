package com.clinic.controllers;

import com.clinic.DTO.AppointmentDTO;
import com.clinic.models.Appointment;
import com.clinic.models.Patient;
import com.clinic.models.Patient;
import com.clinic.services.PatientService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("")
    @ApiOperation(value = "Function that returns all patients", notes = "returns all Patients present in the DB")
    public List<Patient> listPatient() {
        return patientService.listAllPatient();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Function that returns patient by patientId", notes = "returns a Patient from patient_Id")
    public ResponseEntity<Patient> get(@PathVariable Integer id) {
        try {
            Patient patient = patientService.getPatient(id);
            return new ResponseEntity<Patient>(patient, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/appointments")
    @ApiOperation(value = "Function that returns all patient's appointments by patientId", notes = "returns all appointments of single patient")
    public List<AppointmentDTO> getPatientAppointmentsByPatientId(@PathVariable Integer id) {
        List<AppointmentDTO> appointmentsDTO = new ArrayList<>();
        List<Appointment> appointments = patientService.getPatient(id).getAppointments();
        for (Appointment a : appointments) {
            appointmentsDTO.add(
                    new AppointmentDTO(
                            a.getAppointmentId(),
                            a.getPatient().getPatientId(),
                            a.getPatient().getPatientName() + " " + a.getPatient().getPatientSurname(),
                            a.getDoctor().getDoctorName() + " " + a.getDoctor().getDoctorSurname(),
                            a.getAppointmentDate()));
        }
        return appointmentsDTO;
    }

    @PostMapping("")
    @ApiOperation(value = "Function that inserts a single patient")
    public void add(@RequestBody Patient patient) {
        patientService.savePatient(patient);
    }

    @PutMapping("/{id}/updatePatientName")
    @ApiOperation(value = "Function that modifies patientName of a single patient", notes = "returns a HTTP 200 OK, else HTTP 404 NOT FOUND")
    public ResponseEntity<?> updatePatientName(@RequestParam String patientName, @PathVariable Integer id) {
        try {
            Patient existingPatient = patientService.getPatient(id);
            existingPatient.setPatientName(patientName);
            patientService.savePatient(existingPatient);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}/updatePatientSurname")
    @ApiOperation(value = "Function that modifies patientSurname of a single patient", notes = "returns a HTTP 200 OK, else HTTP 404 NOT FOUND")
    public ResponseEntity<?> updatePatientSurname(@RequestParam String patientSurname, @PathVariable Integer id) {
        try {
            Patient existingPatient = patientService.getPatient(id);
            existingPatient.setPatientSurname(patientSurname);
            patientService.savePatient(existingPatient);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}/updatePatientEmail")
    @ApiOperation(value = "Function that modifies patientEmail of a single patient", notes = "returns a HTTP 200 OK, else HTTP 404 NOT FOUND")
    public ResponseEntity<?> updatePatientEmail(@RequestParam String patientEmail, @PathVariable Integer id) {
        try {
            Patient existingPatient = patientService.getPatient(id);
            existingPatient.setPatientEmail(patientEmail);
            patientService.savePatient(existingPatient);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}/updatePatientAddress")
    @ApiOperation(value = "Function that modifies patientAddress of a single patient", notes = "returns a HTTP 200 OK, else HTTP 404 NOT FOUND")
    public ResponseEntity<?> updatePatientAddress(@RequestParam String patientAddress, @PathVariable Integer id) {
        try {
            Patient existingPatient = patientService.getPatient(id);
            existingPatient.setPatientAddress(patientAddress);
            patientService.savePatient(existingPatient);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "Function that delete a single patient")
    public void delete(@PathVariable Integer id) {
        patientService.deletePatient(id);
    }
}