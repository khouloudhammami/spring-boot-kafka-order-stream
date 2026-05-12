package com.khouloud.kafka_mastery.service;

import com.khouloud.kafka_mastery.model.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
//import org.springframework.stereotype.Service;
@Service
public class KafkaProducerService {
    // Spring injecte automatiquement ce template grâce à notre configuration yml
    private final KafkaTemplate<String, Order> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Order order) {
        String topic = "tp-orders"; // Nom du topic (canal)
        
        // On envoie l'objet. Spring va le transformer en JSON tout seul.
        kafkaTemplate.send(topic, order.orderId(), order);
        
        System.out.println("Message envoyé vers Kafka : " + order);
    }
}
