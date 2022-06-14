package com.clinic.models;

import javax.persistence.*;

@Entity
@Table(name = "join_patients_doctors")
public class JoinPatientDoctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jpd_id;

    @ManyToOne
    @JoinColumn(name = "patient_idx")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_idx")
    private Doctor doctor;

    public JoinPatientDoctor() {
    }

    public JoinPatientDoctor(int jpd_id, Patient patient, Doctor doctor) {
        this.jpd_id = jpd_id;
        this.patient = patient;
        this.doctor = doctor;
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
