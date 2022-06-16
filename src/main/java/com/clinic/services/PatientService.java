package com.clinic.services;

import org.springframework.stereotype.Service;
import com.clinic.models.Patient;
import com.clinic.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> listAllPatient() {
        return patientRepository.findAll();
    }

    public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }

    public Patient getPatient(Integer id) {
        return patientRepository.findById(id).get();
    }

    public void deletePatient(Integer id) {
        patientRepository.deleteById(id);
    }

}