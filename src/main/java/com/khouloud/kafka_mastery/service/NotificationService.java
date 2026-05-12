package com.khouloud.kafka_mastery.service;

import com.khouloud.kafka_mastery.model.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @KafkaListener(topics = "tp-orders", groupId = "notification-group")
    public void sendEmail(Order order) {
        System.out.println("📧 [Email Service] Envoi d'un mail de confirmation pour la commande : " + order.orderId());
        System.out.println("Cher client, votre " + order.productName() + " est en cours de préparation !");
        System.out.println("------------------------------------------");
    }
}
