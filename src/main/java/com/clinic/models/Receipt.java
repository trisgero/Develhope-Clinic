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
    private int patient_id;
    private int doctor_id;

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

    @ManyToOne(cascade = CascadeType.ALL)
    public int getPatient_id() {
        return new Patient().getPatient_id();
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public int getDoctor_id() {
        return new Doctor().getDoctor_id();
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
