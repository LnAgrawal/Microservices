package paymentservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import paymentservice.entity.Payment;
import paymentservice.service.PaymentService;

@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @PostMapping("/save")
    public Payment doPayment(@RequestBody Payment payment) throws JsonProcessingException {
        System.out.println("Save payment: "+ new ObjectMapper().writeValueAsString(payment));
        log.info("Save payment: "+ new ObjectMapper().writeValueAsString(payment));
        return paymentService.doPayment(payment);
    }
}
