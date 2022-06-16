package com.clinic.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "appointments")

public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int appointmentId;

    @ManyToOne
    @JoinColumn(name = "patientId")
    @JsonIgnore
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctorId")
    @JsonIgnore
    private Doctor doctor;

    private Date appointmentDate;

    public Appointment() {
    }

    public Appointment(int appointmentId, Patient patientId, Doctor doctorId, Date appointmentDate) {
        this.appointmentId = appointmentId;
        this.patient = patientId;
        this.doctor = doctorId;
        this.appointmentDate = appointmentDate;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public Patient getPatientId() {
        return patient;
    }


    public Doctor getDoctorId() {
        return doctor;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentId(int appointment_id) {
        this.appointmentId = appointment_id;
    }

    public void setPatientId(Patient id) {
        this.patient = id;
    }

    public void setDoctorId(Doctor id) {
        this.doctor = id;
    }

    public void setAppointmentDate(Date appointment_date) {
        this.appointmentDate = appointment_date;
    }

}