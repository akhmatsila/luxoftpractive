package com.ndemidov.spring_kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface Consumer {
    public void acceptMessage(ConsumerRecord<Integer, String> record);
}
