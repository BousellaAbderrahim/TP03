package org.example.exo2;

public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService, OrderDao mockOrderDao) {

        this.orderService = orderService;
    }

    public void createOrder(Order order) {

        orderService.createOrder(order);
    }
}