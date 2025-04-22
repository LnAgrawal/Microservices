package productservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import productservice.dto.Order;

//@FeignClient(url = "http://localhost:8282", value = "order-service")
@FeignClient(url = "http://localhost:8080", value = "order-service")
public interface ApiClient {
    @PostMapping("/order/save")
    Order saveOrder(@RequestBody Order order);
}
