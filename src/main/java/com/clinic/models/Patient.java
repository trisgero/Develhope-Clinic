package com.clinic.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patient_id;

    private String patient_name;
    private String patient_surname;
    private String patient_email;
    private String patient_address;
    private Date patient_birthdate;
    private String patient_fiscode;
    @OneToOne(mappedBy = "patient")
    private User user;
    @OneToMany(mappedBy = "patient")
    private  List<Appointment> appointmentList;
    @OneToMany(mappedBy = "patient")
    private  List<Receipt> receiptList;
    @OneToMany(mappedBy = "patient")
    private List<JoinPatientDoctor> jpd;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private List<Appointment> appointments;

    public Patient() {
    }

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

    public String getPatient_fiscode() {
        return patient_fiscode;
    }

    public void setPatient_fiscode(String patient_fiscode) {
        this.patient_fiscode = patient_fiscode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    public List<Receipt> getReceiptList() {
        return receiptList;
    }

    public void setReceiptList(List<Receipt> receiptList) {
        this.receiptList = receiptList;
    }

    public List<JoinPatientDoctor> getJpd() {
        return jpd;
    }

    public void setJpd(List<JoinPatientDoctor> jpd) {
        this.jpd = jpd;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Patient(int patient_id, String patient_name, String patient_surname, String patient_email, String patient_address, Date patient_birthdate, String patient_fiscode, User user, List<Appointment> appointmentList, List<Receipt> receiptList, List<JoinPatientDoctor> jpd, List<Appointment> appointments) {
        this.patient_id = patient_id;
        this.patient_name = patient_name;
        this.patient_surname = patient_surname;
        this.patient_email = patient_email;
        this.patient_address = patient_address;
        this.patient_birthdate = patient_birthdate;
        this.patient_fiscode = patient_fiscode;
        this.user = user;
        this.appointmentList = appointmentList;
        this.receiptList = receiptList;
        this.jpd = jpd;
        this.appointments = appointments;


    }
}