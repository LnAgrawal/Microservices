package orderservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import orderservice.dto.OrderDto;
import orderservice.entity.Order;
import orderservice.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/order")
@Slf4j
public class OrderController {
    @Autowired
    OrderServiceImpl orderService;

    @PostMapping(path = "/save")
    public OrderDto saveOrder(@RequestBody Order order) throws JsonProcessingException {
        System.out.println("Save order: "+ new ObjectMapper().writeValueAsString(order));
        log.info("Save order: "+ new ObjectMapper().writeValueAsString(order));
        return orderService.saveOrder(order);
    }
}
