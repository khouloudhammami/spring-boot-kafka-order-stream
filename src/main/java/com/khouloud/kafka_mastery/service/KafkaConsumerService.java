package com.khouloud.kafka_mastery.service;

import com.khouloud.kafka_mastery.model.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    // Cette annotation dit à Spring d'écouter en permanence le topic "tp-orders"
    @KafkaListener(topics = "tp-orders", groupId = "inventory-group")
    public void consumeOrder(Order order) {
        System.out.println("📥 Message reçu de Kafka !");
        System.out.println("ID Commande : " + order.orderId());
        System.out.println("Produit : " + order.productName());
        System.out.println("Total : " + (order.quantity() * order.price()) + "€");
        System.out.println("------------------------------------------");
    }
}
