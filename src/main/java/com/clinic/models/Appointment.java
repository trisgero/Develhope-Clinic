package com.clinic.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "appointments")

public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int appointment_id;

    @ManyToOne
    @JoinColumn(name = "patient_ids")
    @JsonIgnore
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_ids")
    @JsonIgnore
    private Doctor doctor;

    private Date appointment_date;

    public Appointment() {
    }

    public Appointment(int appointment_id, Patient patient, Doctor doctor, Date appointment_date) {
        this.appointment_id = appointment_id;
        this.patient = patient;
        this.doctor = doctor;
        this.appointment_date = appointment_date;
    }

    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
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

    public Date getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(Date appointment_date) {
        this.appointment_date = appointment_date;
    }
}
