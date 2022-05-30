package com.clinic.models;

import javax.persistence.*;

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
