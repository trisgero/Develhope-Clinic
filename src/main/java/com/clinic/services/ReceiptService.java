package com.clinic.services;

import com.clinic.models.Receipt;
import com.clinic.repositories.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;
    public List<Receipt> listAllReceipt() {
        return receiptRepository.findAll();
    }

    public void saveReceipt(Receipt receipt) {
        receiptRepository.save(receipt);
    }

    public Receipt getReceipt(Integer id) {
        return receiptRepository.findById(id).get();
    }

    public void deleteReceipt(Integer id) {
        receiptRepository.deleteById(id);
    }
}