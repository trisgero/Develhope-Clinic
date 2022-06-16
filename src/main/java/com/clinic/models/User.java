package com.clinic.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    @OneToOne
    private Patient patient;
    @OneToOne
    private Doctor doctor;

    @Enumerated(EnumType.STRING)
    @Column(name = "userKind")
    private UserKind user_kind;
    private String username;
    private String password;

    public User(int user_id, Patient patient, Doctor doctor, String username, String password) {
        this.user_id = user_id;
        this.patient = patient;
        this.doctor = doctor;
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public UserKind getUser_kind() {
        return user_kind;
    }

    public void setUser_kind(UserKind user_kind) {
        this.user_kind = user_kind;
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