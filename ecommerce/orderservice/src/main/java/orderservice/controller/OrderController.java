package orderservice.controller;

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
public class OrderController {
    @Autowired
    OrderServiceImpl orderService;

    @PostMapping(path = "/save")
    public OrderDto saveOrder(@RequestBody Order order){
        return orderService.saveOrder(order);
    }
}
