package com.clinic.controllers;

import com.clinic.models.JoinPatientDoctor;
import com.clinic.services.JoinPatientDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/jpd")
public class JoinPatientDoctorController {

    @Autowired
    JoinPatientDoctorService joinPatientDoctorService;

    @GetMapping("")
    public List<JoinPatientDoctor> list() {
        return joinPatientDoctorService.listAllJPD();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JoinPatientDoctor> get(@PathVariable Integer id) {
        try {
            JoinPatientDoctor jpd = joinPatientDoctorService.getJPD(id);
            return new ResponseEntity<JoinPatientDoctor>(jpd, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<JoinPatientDoctor>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody JoinPatientDoctor jpd) {
        joinPatientDoctorService.saveJPD(jpd);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody JoinPatientDoctor jpd, @PathVariable Integer id) {
        try {
            JoinPatientDoctor jpdExists = joinPatientDoctorService.getJPD(id);
            jpd.setJpd_id(jpd.getJpd_id());
            joinPatientDoctorService.saveJPD(jpd);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        joinPatientDoctorService.deleteJPD(id);
    }
}
