package com.clinic.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;

    private String patientName;
    private String patientSurname;
    private String patientEmail;
    private String patientAddress;
    private LocalDate patientBirthdate;
    private String patientFiscode;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private List<Appointment> appointments;

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Patient() {
    }

    public Patient(int patientId, String patientName, String patientSurname, String patientEmail, String patientAddress, LocalDate patientBirthdate, String patientFiscode) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientSurname = patientSurname;
        this.patientEmail = patientEmail;
        this.patientAddress = patientAddress;
        this.patientBirthdate = patientBirthdate;
        this.patientFiscode = patientFiscode;
    }

    public String getPatientFiscode() {
        return patientFiscode;
    }

    public void setPatientFiscode(String patientFiscode) {
        this.patientFiscode = patientFiscode;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSurname() {
        return patientSurname;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public LocalDate getPatientBirthdate() {
        return patientBirthdate;
    }

    public void setPatientBirthdate(LocalDate patientBirthdate) {
        this.patientBirthdate = patientBirthdate;
    }

}