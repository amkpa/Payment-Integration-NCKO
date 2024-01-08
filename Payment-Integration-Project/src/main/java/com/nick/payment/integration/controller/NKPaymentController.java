package com.nick.payment.integration.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nick.payment.integration.entity.NKPayment;
import com.nick.payment.integration.service.NKPaymentService;

@RestController
@RequestMapping("/payments")
public class NKPaymentController {

    @Autowired
    private NKPaymentService paymentService;

    @GetMapping("/all")
    public ResponseEntity<List<NKPayment>> getAllPayments() {
        List<NKPayment> payments = paymentService.getAllPayments();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<NKPayment> getPaymentById(@PathVariable Long paymentId) {
        NKPayment payment = paymentService.getPaymentById(paymentId);
        if (payment != null) {
            return new ResponseEntity<>(payment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createPayment(@RequestBody NKPayment payment,
                                               @RequestParam Long userId) {
        try {
            paymentService.savePayment(payment, userId);
            return ResponseEntity.status(HttpStatus.CREATED).body("Payment created successfully.");
        } catch (Exception e) {
            // Handle exceptions as needed
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }


    @PutMapping("/update/{paymentId}")
    public ResponseEntity<Object> updatePayment(@PathVariable Long paymentId, @RequestBody NKPayment payment) {
        NKPayment existingPayment = paymentService.getPaymentById(paymentId);
        if (existingPayment != null) {
            payment.setNkPaymentId(paymentId);
            paymentService.updatePayment(payment);
            return ResponseEntity.status(HttpStatus.OK).body("Payment updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Payment not found.");
        }
    }

    @DeleteMapping("/delete/{paymentId}")
    public ResponseEntity<Object> deletePayment(@PathVariable Long paymentId) {
        NKPayment existingPayment = paymentService.getPaymentById(paymentId);
        if (existingPayment != null) {
            paymentService.deletePayment(paymentId);
            return ResponseEntity.status(HttpStatus.OK).body("Payment deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Payment not found.");
        }
    }
}
