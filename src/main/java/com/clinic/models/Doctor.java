package com.clinic.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;

    private String doctorName;
    private String doctorSurname;
    private String doctorTelephone;
    private String doctorAddress;
    private String doctorSpecialization;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private List<Appointment> appointments;

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Doctor() {
    }

    public Doctor(int doctorId, String doctorName, String doctorSurname, String doctorTelephone, String doctorAddress, String doctorSpecialization, List<Appointment> appointments) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorSurname = doctorSurname;
        this.doctorTelephone = doctorTelephone;
        this.doctorAddress = doctorAddress;
        this.doctorSpecialization = doctorSpecialization;
        this.appointments = appointments;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public int getdoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctor_id) {
        this.doctorId = doctor_id;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctor_name) {
        this.doctorName = doctor_name;
    }

    public String getDoctorSurname() {
        return doctorSurname;
    }

    public void setDoctorSurname(String doctor_surname) {
        this.doctorSurname = doctor_surname;
    }

    public String getDoctorTelephone() {
        return doctorTelephone;
    }

    public void setDoctorTelephone(String doctor_telephone) {
        this.doctorTelephone = doctor_telephone;
    }

    public String getDoctorAddress() {
        return doctorAddress;
    }

    public void setdoctorAddress(String doctor_address) {
        this.doctorAddress = doctor_address;
    }

    public String getDoctorSpecialization() {
        return doctorSpecialization;
    }

    public void setDoctorSpecialization(String doctor_specialization) {
        this.doctorSpecialization = doctor_specialization;
    }

}