package com.ndemidov.spring_kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer  implements Producer{
    @Value("${message.topic}")
    private String topicName;

    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;

    @Override
    public void sendMessage(String message) {
        int hashKey = message.hashCode();
        kafkaTemplate.send(topicName, hashKey, message);
    }
}
