package paymentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paymentservice.entity.Payment;
import paymentservice.repository.PaymentRepository;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public Payment doPayment(Payment payment) {
        payment.setTransactionId(UUID.randomUUID().toString());
        payment.setStatus(paymentStatus());
        return paymentRepository.save(payment);
    }

    private String paymentStatus() {
        return new Random().nextBoolean()?"SUCCESS":"FAILED";
    }
}
