package com.clinic.repositories;

import com.clinic.models.JoinPatientDoctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoinPatientDoctorRepository extends JpaRepository<JoinPatientDoctor, Integer> {
}
