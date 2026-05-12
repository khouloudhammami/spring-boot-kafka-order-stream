package com.khouloud.kafka_mastery.model;

// Un record génère automatiquement les getters, constructor, equals, et toString
// C'est plus léger qu'une classe, c'est immuable, et c'est parfait pour représenter un événement
// et pour la sécurité des threads
public record Order(
    String orderId,
    String productName,
    int quantity,
    double price
) {}
