package com.clinic.service;

import org.springframework.stereotype.Service;
import com.clinic.model.Patient;
import com.clinic.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
