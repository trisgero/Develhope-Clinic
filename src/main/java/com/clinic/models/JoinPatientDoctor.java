package com.clinic.models;

import javax.persistence.*;

@Entity
@Table(name = "join_patients_doctors")
public class JoinPatientDoctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jpd_id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public JoinPatientDoctor() {
    }

    public JoinPatientDoctor(int join_id, Patient patient_id, Doctor doctor_id) {
        this.jpd_id = join_id;
        this.patient = patient_id;
        this.doctor = doctor_id;
    }


    public int getJpd_id() {
        return jpd_id;
    }

    public void setJpd_id(int jpd_id) {
        this.jpd_id = jpd_id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
