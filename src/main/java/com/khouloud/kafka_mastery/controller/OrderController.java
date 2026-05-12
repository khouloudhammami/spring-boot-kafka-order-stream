package com.khouloud.kafka_mastery.controller;

import com.khouloud.kafka_mastery.model.Order;
import com.khouloud.kafka_mastery.service.KafkaProducerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final KafkaProducerService producerService;

    // Injection de notre service via le constructeur
    public OrderController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/publish")
    public String publishOrder(@RequestBody Order order) {
        producerService.sendMessage(order);
        return "✅ Commande envoyée avec succès à Kafka !";
    }
}
