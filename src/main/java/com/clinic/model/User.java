package com.clinic.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User{

    private int user_id;
    private Patient patient_id;
    private Doctor doctor_id;

    private userKind user_kind;
    private String username;
    private String password;

    public User(int user_id, Patient patient_id, Doctor doctor_id, String username, String password) {
        this.user_id = user_id;
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @ManyToOne
    public Patient getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Patient patient_id) {
        this.patient_id = patient_id;
    }

    @ManyToOne
    public Doctor getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Doctor doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

enum userKind {
    PATIENT,
    DOCTORS,
    SECRETARY;
}

