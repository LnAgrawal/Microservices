package orderservice.service;

import orderservice.dto.OrderDto;
import orderservice.entity.Order;

public interface OrderService {

    public OrderDto saveOrder(Order order);
}
