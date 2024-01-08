package com.nick.payment.integration.service;

import com.nick.payment.integration.entity.NKPayment;

import java.util.List;

public interface NKPaymentService {

    List<NKPayment> getAllPayments();

    NKPayment getPaymentById(Long paymentId);

    void savePayment(NKPayment payment, Long userId);

    void updatePayment(NKPayment payment);

    void deletePayment(Long paymentId);


}
