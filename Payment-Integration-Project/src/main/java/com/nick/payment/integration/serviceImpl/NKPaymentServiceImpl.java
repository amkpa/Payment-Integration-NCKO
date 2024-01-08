package com.nick.payment.integration.serviceImpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nick.payment.integration.entity.NKPayment;
import com.nick.payment.integration.entity.NKUser;
import com.nick.payment.integration.repo.NKPaymentRepo;
import com.nick.payment.integration.repo.NKUserRepo;
import com.nick.payment.integration.service.NKPaymentService;

@Service
public class NKPaymentServiceImpl implements NKPaymentService {

    @Autowired
    private NKPaymentRepo paymentRepository;

    @Autowired
    private NKUserRepo userRepository;
    
    @Override
    public List<NKPayment> getAllPayments() {
    	return paymentRepository.findAllWithUser();
    }


    @Override
    public NKPayment getPaymentById(Long paymentId) {
        Optional<NKPayment> optionalPayment = paymentRepository.findById(paymentId);
        return optionalPayment.orElse(null);
    }

    @Override
    public void savePayment(NKPayment payment, Long userId) {
        if (userId == null) {
            throw new RuntimeException("User ID must be provided for associating the payment with a user.");
        }

        NKUser user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        payment.setNkUser(user);
        paymentRepository.save(payment);
    }



    @Override
    public void updatePayment(NKPayment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public void deletePayment(Long paymentId) {
        paymentRepository.deleteById(paymentId);
    }

    // You can add more service methods as needed

}
