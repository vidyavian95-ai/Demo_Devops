package com.bookstoreapi.implementation;

import com.bookstoreapi.entity.Order;
import com.bookstoreapi.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerImplementation {

    private final OrderRepository orderRepository;

    public CustomerImplementation(
            final OrderRepository orderRepository) {

        this.orderRepository = orderRepository;
    }

    public Order createOrder(final Order order) {
        return orderRepository.save(order);
    }

    public Order findOrderByCustomerId(final Long orderId) {
        return orderRepository.findById(orderId)
                .orElse(null);
    }
}