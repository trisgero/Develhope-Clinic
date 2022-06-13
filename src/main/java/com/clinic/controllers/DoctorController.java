package com.clinic.controllers;

import com.clinic.models.Doctor;
import com.clinic.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @GetMapping("")
    public List<Doctor> listDoctor(){
        return doctorService.listAllDoctor();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> get(@PathVariable Integer id) {
        try {
            Doctor doctor = doctorService.getDoctor(id);
            return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Doctor>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Doctor doctor) {
        doctorService.saveDoctor(doctor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Doctor doctor, @PathVariable Integer doctor_id) {
        try {
            Doctor existDoctor = doctorService.getDoctor(doctor_id);
            doctor.setDoctor_id(doctor_id);
            doctorService.saveDoctor(doctor);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer doctor_id) {
        doctorService.deleteDoctor(doctor_id);
    }

}
