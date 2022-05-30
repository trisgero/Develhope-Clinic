package com.clinic.models;

import javax.persistence.*;
import java.util.List;

/**
 * aggiungere patient_id e doctor_id
 */

@Entity
@Table(name = "receipt")
public class Receipt {

    @Id
    @Column(name = "id", nullable = false)
    private Long receipt_id;
    private String receipt_description;
    private List<Patient> patient_id;
    private List<Doctor> doctor_id;

    public Long getReceipt_id() {
        return receipt_id;
    }

    public void setReceipt_id(Long receipt_id) {
        this.receipt_id = receipt_id;
    }

    @OneToMany
    public List<Patient> getPatient_id() {
        return patient_id;
    }

    @OneToMany
    public void setPatient_id(List<Patient> patient_id) {
        this.patient_id = patient_id;
    }

    @OneToMany
    public List<Doctor> getDoctor_id() {
        return doctor_id;
    }

    @OneToMany
    public void setDoctor_id(List<Doctor> doctor_id) {
        this.doctor_id = doctor_id;
    }

    private List<Doctor> doctor_id;
    public Long getId() {
        return receipt_id;
    }

    public void setId(Long id) {
        this.receipt_id = id;
    }

    public Receipt() {
    }

    public Receipt(Long id, String receipt_description) {
        this.receipt_id = id;
        this.receipt_description = receipt_description;
    }

    public String getReceipt_description() {
        return receipt_description;
    }

    public void setReceipt_description(String receipt_description) {
        this.receipt_description = receipt_description;
    }
}
