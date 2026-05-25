package com.bookstoreapi.Kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Kafka producer service.
 */
@Service
public final class KafkaProducerService {

    /**
     * Kafka template instance.
     */
    private final KafkaTemplate<String, String> kafkaTemplate;

    /**
     * Constructor injection.
     *
     * @param kafkaTemplateValue kafka template
     */
    public KafkaProducerService(
            final KafkaTemplate<String, String> kafkaTemplateValue) {

        this.kafkaTemplate = kafkaTemplateValue;
    }

    /**
     * Sends message to kafka topic.
     *
     * @param topic topic name
     * @param message message value
     */
    public void sendMessage(
            final String topic,
            final String message) {

        kafkaTemplate.send(topic, message);
    }
}