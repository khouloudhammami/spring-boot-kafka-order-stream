package com.khouloud.kafka_mastery.service;

import com.khouloud.kafka_mastery.model.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "tp-orders", groupId = "inventory-group")
    public void consumeOrder(Order order) {
        double total = order.quantity() * order.price();
        
        System.out.println("📥 [Inventory Service] Analyse de la commande : " + order.orderId());
        
        if (total > 100) {
            System.out.println("💎 COMMANDE VIP DÉTECTÉE : " + total + "€ - Priorité haute en préparation !");
        } else {
            System.out.println("✅ Commande standard enregistrée.");
        }
        System.out.println("------------------------------------------");
    }
}
