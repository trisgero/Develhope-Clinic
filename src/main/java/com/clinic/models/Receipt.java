package com.clinic.models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "receipts")
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int receipt_id;
    private String receipt_description;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Doctor doctor;

    public Receipt() {
    }

    public Receipt(int receipt_id, String receipt_description, Patient patient, Doctor doctor) {
        this.receipt_id = receipt_id;
        this.receipt_description = receipt_description;
        this.patient = patient;
        this.doctor = doctor;
    }

    public int getReceipt_id() {
        return receipt_id;
    }

    public void setReceipt_id(int receipt_id) {
        this.receipt_id = receipt_id;
    }

    public String getReceipt_description() {
        return receipt_description;
    }

    public void setReceipt_description(String receipt_description) {
        this.receipt_description = receipt_description;
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
}
