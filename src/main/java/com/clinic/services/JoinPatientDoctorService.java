package com.clinic.services;

import com.clinic.models.JoinPatientDoctor;
import com.clinic.repositories.JoinPatientDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class JoinPatientDoctorService {

    @Autowired
    private JoinPatientDoctorRepository joinPatientDoctorRepository;

    public List<JoinPatientDoctor> listAllJPD() {
        return joinPatientDoctorRepository.findAll();
    }

    public void saveJPD(JoinPatientDoctor user) {
        joinPatientDoctorRepository.save(user);
    }

    public JoinPatientDoctor getJPD(Integer id) {
        return joinPatientDoctorRepository.findById(id).get();
    }

    public void deleteJPD(Integer id) {
        joinPatientDoctorRepository.deleteById(id);
    }
}
