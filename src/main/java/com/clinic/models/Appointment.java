package com.clinic.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "appointment")

public class Appointment {

    private int appointment_id;
    private List<Patient> patient_id;
    private List<Doctor> doctor_id;
    private Date appointment_date;

    public Appointment() {
    }

    public Appointment(int appointment_id, List<Patient> patient_id, List<Doctor> doctor_id, Date appointment_date) {
        this.appointment_id = appointment_id;
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
        this.appointment_date = appointment_date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getAppointment_id() {
        return appointment_id;
    }

    @ManyToMany
    public List<Patient> getPatient_id() {
        return patient_id;
    }

    @ManyToMany
    public List<Doctor> getDoctor_id() {
        return doctor_id;
    }

    public Date getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }

    public void setPatient_id(List<Patient> patient_id) {
        this.patient_id = patient_id;
    }

    public void setDoctor_id(List<Doctor> doctor_id) {
        this.doctor_id = doctor_id;
    }

    public void setAppointment_date(Date appointment_date) {
        this.appointment_date = appointment_date;
    }

}
