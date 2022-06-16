package com.clinic.models;

import javax.persistence.*;


@Entity
@Table(name = "receipts")
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int receiptId;
    private String receiptDescription;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Doctor doctor;

    public Receipt() {
    }

    public Receipt(int receipt_id, String receipt_description, Patient patient, Doctor doctor) {
        this.receiptId = receipt_id;
        this.receiptDescription = receipt_description;
        this.patient = patient;
        this.doctor = doctor;
    }

    public int getReceipt_id() {
        return receiptId;
    }

    public void setReceipt_id(int receipt_id) {
        this.receiptId = receipt_id;
    }

    public String getReceipt_description() {
        return receiptDescription;
    }

    public void setReceipt_description(String receipt_description) {
        this.receiptDescription = receipt_description;
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