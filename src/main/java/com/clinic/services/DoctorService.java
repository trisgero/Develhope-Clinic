package com.clinic.services;

import com.clinic.models.Doctor;
import com.clinic.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> listAllDoctor() {
        return doctorRepository.findAll();
    }

    public void saveDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public Doctor getDoctor(Integer id) {
        return doctorRepository.findById(id).get();
    }

    public void deleteDoctor(Integer id) {
        doctorRepository.deleteById(id);
    }

}