package com.clinic.models;

import com.clinic.repositories.AppointmentRepository;
import com.clinic.services.AppointmentService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctor_id;

    private String doctor_name;
    private String doctor_surname;
    private String doctor_telephone;
    private String doctor_address;
    private String doctor_specialization;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private List<Appointment> appointments;

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Doctor() {
    }

    public Doctor(int doctor_id, String doctor_name, String doctor_surname, String doctor_telephone, String doctor_address, String doctor_specialization, List<Appointment> appointments) {
        this.doctor_id = doctor_id;
        this.doctor_name = doctor_name;
        this.doctor_surname = doctor_surname;
        this.doctor_telephone = doctor_telephone;
        this.doctor_address = doctor_address;
        this.doctor_specialization = doctor_specialization;
        this.appointments = appointments;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDoctor_surname() {
        return doctor_surname;
    }

    public void setDoctor_surname(String doctor_surname) {
        this.doctor_surname = doctor_surname;
    }

    public String getDoctor_telephone() {
        return doctor_telephone;
    }

    public void setDoctor_telephone(String doctor_telephone) {
        this.doctor_telephone = doctor_telephone;
    }

    public String getDoctor_address() {
        return doctor_address;
    }

    public void setDoctor_address(String doctor_address) {
        this.doctor_address = doctor_address;
    }

    public String getDoctor_specialization() {
        return doctor_specialization;
    }

    public void setDoctor_specialization(String doctor_specialization) {
        this.doctor_specialization = doctor_specialization;
    }

}