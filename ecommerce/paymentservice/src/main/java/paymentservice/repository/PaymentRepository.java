package paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import paymentservice.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
