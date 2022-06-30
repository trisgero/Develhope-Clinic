package com.clinic.controllers;

import com.clinic.DTO.AppointmentDTO;
import com.clinic.models.Appointment;
import com.clinic.models.Patient;
import com.clinic.models.Patient;
import com.clinic.services.PatientService;
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
    public List<Patient> listPatient() {
        return patientService.listAllPatient();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> get(@PathVariable Integer id) {
        try {
            Patient patient = patientService.getPatient(id);
            return new ResponseEntity<Patient>(patient, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/appointments")
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
    public void add(@RequestBody Patient patient) {
        patientService.savePatient(patient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Patient patient, @PathVariable Integer id) {
        try {
            patientService.getPatient(id);
            patient.setPatientId(id);
            patientService.savePatient(patient);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}/updatePatientName")
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
    public ResponseEntity<?> updatePatientTelephone(@RequestParam String patientEmail, @PathVariable Integer id) {
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
    public void delete(@PathVariable Integer id) {
        patientService.deletePatient(id);
    }
}