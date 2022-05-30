package com.clinic.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "patient")
public class Patient {

    private int patient_id;
    private String patient_name;
    private String patient_surname;
    private String patient_email;
    private String patient_address;
    private Date patient_birthdate;

    public Patient() {
    }

    public Patient(int patient_id, String patient_name, String patient_surname, String patient_email, String patient_address, Date patient_birthdate) {
        this.patient_id = patient_id;
        this.patient_name = patient_name;
        this.patient_surname = patient_surname;
        this.patient_email = patient_email;
        this.patient_address = patient_address;
        this.patient_birthdate = patient_birthdate;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getPatient_surname() {
        return patient_surname;
    }

    public void setPatient_surname(String patient_surname) {
        this.patient_surname = patient_surname;
    }

    public String getPatient_email() {
        return patient_email;
    }

    public void setPatient_email(String patient_email) {
        this.patient_email = patient_email;
    }

    public String getPatient_address() {
        return patient_address;
    }

    public void setPatient_address(String patient_address) {
        this.patient_address = patient_address;
    }

    public Date getPatient_birthdate() {
        return patient_birthdate;
    }

    public void setPatient_birthdate(Date patient_birthdate) {
        this.patient_birthdate = patient_birthdate;
    }
}
