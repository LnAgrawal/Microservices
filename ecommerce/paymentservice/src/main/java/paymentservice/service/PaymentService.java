package paymentservice.service;

import paymentservice.entity.Payment;

public interface PaymentService {
    Payment doPayment(Payment payment);
}
