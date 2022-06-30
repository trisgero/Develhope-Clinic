package com.clinic.controllers;

import com.clinic.models.Receipt;
import com.clinic.services.ReceiptService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {

    @Autowired
    ReceiptService receiptService;

    @GetMapping("")
    @ApiOperation(value = "Function that returns all receipts", notes = "returns all Receipts present in the DB")
    public List<Receipt> list() {
        return receiptService.listAllReceipt();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Function that returns receipt by receiptId", notes = "returns a Receipt from receipt_Id")
    public ResponseEntity<Receipt> get(@PathVariable Integer id) {
        try {
            Receipt receipt = receiptService.getReceipt(id);
            return new ResponseEntity<Receipt>(receipt, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Receipt>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    @ApiOperation(value = "Function that inserts a single receipt")
    public void add(@RequestBody Receipt receipt) {
        receiptService.saveReceipt(receipt);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Function that deletes a single receipt")
    public void delete(@PathVariable Integer id) {
        receiptService.deleteReceipt(id);
    }

}