package com.ndemidov.spring_kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer implements Consumer {

    @Override
    @KafkaListener(topics = "${message.topic}")
    public void acceptMessage(ConsumerRecord<Integer, String> record) {
        String value = record.value();
        Integer key = record.key();
        System.out.printf("message = %s accepted, key = %s%n", value, key);
    }
}
