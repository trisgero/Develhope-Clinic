package com.clinic.controller;

import com.clinic.model.Patient;
import com.clinic.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("")
    public List<Patient> listPatient(){
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

    @PostMapping("/")
    public void add(@RequestBody Patient patient) {
        patientService.savePatient(patient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Patient patient, @PathVariable Integer patient_id) {
        try {
            Patient existUser = patientService.getPatient(patient_id);
            patient.setPatient_id(patient_id);
            patientService.savePatient(patient);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer patient_id) {

        patientService.deletePatient(patient_id);
    }


}
