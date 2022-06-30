package com.clinic.controllers;

import com.clinic.DTO.AppointmentDTO;
import com.clinic.models.Appointment;
import com.clinic.models.Doctor;
import com.clinic.services.AppointmentService;
import com.clinic.services.DoctorService;
import com.clinic.services.ReceiptService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @Autowired
    AppointmentService appointmentService;
    @Autowired
    ReceiptService receiptService;

    @GetMapping("")
    @ApiOperation(value = "Function that returns all doctors", notes = "returns all Doctors present in the DB")
    public List<Doctor> listDoctor() {
        return doctorService.listAllDoctor();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Function that returns doctor by doctorId", notes = "returns a Doctor from doctor_Id")
    public ResponseEntity<Doctor> get(@PathVariable Integer id) {
        try {
            Doctor doctor = doctorService.getDoctor(id);
            return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Doctor>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/appointments")
    @ApiOperation(value = "Function that returns all doctor's appointments by doctorId", notes = "returns all appointments of single doctor")
    public List<AppointmentDTO> getDoctorAppointmentByDoctorId(@PathVariable Integer id) {
        List<AppointmentDTO> appointmentsDTO = new ArrayList<>();
        List<Appointment> appointments = doctorService.getDoctor(id).getAppointments();
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
    @ApiOperation(value = "Function that inserts a single doctor")
    public void add(@RequestBody Doctor doctor) {
        doctorService.saveDoctor(doctor);
    }

    @PutMapping("/{id}/updateDoctorName")
    @ApiOperation(value = "Function that modifies doctorName of a single doctor", notes = "returns a HTTP 200 OK, else HTTP 404 NOT FOUND")
    public ResponseEntity<?> updateDoctorName(@RequestParam String doctorName, @PathVariable Integer id) {
        try {
            Doctor existingDoctor = doctorService.getDoctor(id);
            existingDoctor.setDoctorName(doctorName);
            doctorService.saveDoctor(existingDoctor);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}/updateDoctorSurname")
    @ApiOperation(value = "Function that modifies doctorSurname of a single doctor", notes = "returns a HTTP 200 OK, else HTTP 404 NOT FOUND")
    public ResponseEntity<?> updateDoctorSurname(@RequestParam String doctorSurname, @PathVariable Integer id) {
        try {
            Doctor existingDoctor = doctorService.getDoctor(id);
            existingDoctor.setDoctorSurname(doctorSurname);
            doctorService.saveDoctor(existingDoctor);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}/updateDoctorTelephone")
    @ApiOperation(value = "Function that modifies doctorTelephone of a single doctor", notes = "returns a HTTP 200 OK, else HTTP 404 NOT FOUND")
    public ResponseEntity<?> updateDoctorTelephone(@RequestParam String doctorTelephone, @PathVariable Integer id) {
        try {
            Doctor existingDoctor = doctorService.getDoctor(id);
            existingDoctor.setDoctorTelephone(doctorTelephone);
            doctorService.saveDoctor(existingDoctor);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}/updateDoctorAddress")
    @ApiOperation(value = "Function that modifies doctorAddress of a single doctor", notes = "returns a HTTP 200 OK, else HTTP 404 NOT FOUND")
    public ResponseEntity<?> updateDoctorAddress(@RequestParam String doctorAddress, @PathVariable Integer id) {
        try {
            Doctor existingDoctor = doctorService.getDoctor(id);
            existingDoctor.setDoctorAddress(doctorAddress);
            doctorService.saveDoctor(existingDoctor);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}/updateDoctorSpecialization")
    @ApiOperation(value = "Function that modifies doctorSpecialition of a single doctor", notes = "returns a HTTP 200 OK, else HTTP 404 NOT FOUND")
    public ResponseEntity<?> updateDoctorSpecialization(@RequestParam String doctorSpecialization, @PathVariable Integer id) {
        try {
            Doctor existingDoctor = doctorService.getDoctor(id);
            existingDoctor.setDoctorSpecialization(doctorSpecialization);
            doctorService.saveDoctor(existingDoctor);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Function that deletes a single doctor")
    public void delete(@PathVariable Integer id) {
        doctorService.deleteDoctor(id);
    }
    
}