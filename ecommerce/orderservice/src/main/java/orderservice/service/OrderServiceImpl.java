package orderservice.service;

import orderservice.dto.OrderDto;
import orderservice.dto.Payment;
import orderservice.entity.Order;
import orderservice.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    WebClient webClient;
    /*@Override
    public Order saveOrder(Order order) {
        Payment payment = restTemplate.postForObject("http://localhost:8382/payment/save", new Payment(), Payment.class);
        order.setStatus(payment.getStatus());
        order.setTransactionId(payment.getTransactionId());
        return orderRepository.save(order);
    }*/
    @Override
    public OrderDto saveOrder(Order order) {
        Payment payment = webClient.post()
                        .uri("/payment/save")
                .bodyValue(new Payment())
                .retrieve()
                .toEntity(Payment.class)
                .block()
                .getBody();
        OrderDto resOrderDto = new OrderDto();
        Order resOrder = orderRepository.save(order);
        resOrderDto.setId(resOrder.getId());
        resOrderDto.setName(resOrder.getName());
        resOrderDto.setQuantity(resOrder.getQuantity());
        resOrderDto.setPrice(resOrder.getPrice());
        resOrderDto.setStatus(payment.getStatus());
        resOrderDto.setTransactionId(payment.getTransactionId());

        return resOrderDto;
    }

  /*  @Override
    public Order saveOrder(Order order) {
        Mono<ResponseEntity<Payment>> payment = webClient.post()
                .uri("/payment/save")
                .bodyValue(new Payment())
                .retrieve()
                .toEntity(Payment.class);
        payment.subscribe((re)->{
            Payment obj = re.getBody();
            order.setStatus(obj.getStatus());
            order.setTransactionId(obj.getTransactionId());
        });

        return orderRepository.save(order);
    }*/
}
