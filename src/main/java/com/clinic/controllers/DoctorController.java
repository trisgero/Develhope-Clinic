package com.clinic.controllers;

import com.clinic.DTO.AppointmentDTO;
import com.clinic.models.Appointment;
import com.clinic.models.Doctor;
import com.clinic.services.AppointmentService;
import com.clinic.services.DoctorService;
import com.clinic.services.ReceiptService;
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
    public List<Doctor> listDoctor() {
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

    @GetMapping("/{id}/appointments")
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
    public void add(@RequestBody Doctor doctor) {
        doctorService.saveDoctor(doctor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDoctor(@RequestBody Doctor doctor, @PathVariable Integer id) {
        try {
            doctorService.getDoctor(id);
            doctor.setDoctorId(id);
            doctorService.saveDoctor(doctor);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        doctorService.deleteDoctor(id);
    }

}