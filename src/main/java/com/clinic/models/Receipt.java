package com.clinic.models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "receipt")
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long receipt_id;
    private String receipt_description;
    private List<Patient> patient_id;
    private List<Doctor> doctor_id;

    public Receipt() {
    }

    public Receipt(Long id, String receipt_description) {
        this.receipt_id = id;
        this.receipt_description = receipt_description;
    }


    public Long getReceipt_id() {
        return receipt_id;
    }

    public void setReceipt_id(Long receipt_id) {
        this.receipt_id = receipt_id;
    }

    @OneToMany
    @JoinColumn(name = "patient_id")
    public List<Patient> getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(List<Patient> patient_id) {
        this.patient_id = patient_id;
    }

    @OneToMany
    @JoinColumn(name = "doctor_id")
    public List<Doctor> getDoctor_id() {
        return doctor_id;
    }


    public void setDoctor_id(List<Doctor> doctor_id) {
        this.doctor_id = doctor_id;
    }

    public Long getId() {
        return receipt_id;
    }

    public void setId(Long id) {
        this.receipt_id = id;
    }


    public String getReceipt_description() {
        return receipt_description;
    }

    public void setReceipt_description(String receipt_description) {
        this.receipt_description = receipt_description;
    }
}
