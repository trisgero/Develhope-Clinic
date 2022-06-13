package com.clinic.controllers;

import com.clinic.models.Receipt;
import com.clinic.services.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/receipt")
public class ReceiptController {

    @Autowired
    ReceiptService receiptService;

    @GetMapping("")
    public List<Receipt> list() {
        return receiptService.listAllReceipt();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receipt> get(@PathVariable Integer id) {
        try {
            Receipt receipt = receiptService.getReceipt(id);
            return new ResponseEntity<Receipt>(receipt, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Receipt>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Receipt receipt) {
        receiptService.saveReceipt(receipt);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Receipt receipt, @PathVariable Integer id) {
        try {
            Receipt existReceipt = receiptService.getReceipt(id);
            receipt.setReceipt_id(receipt.getReceipt_id());
            receiptService.saveReceipt(receipt);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        receiptService.deleteReceipt(id);
    }

}
