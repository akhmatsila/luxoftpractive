package com.ndemidov.spring_kafka;

import com.ndemidov.spring_kafka.utils.MessageCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class SpringKafkaApplication {

	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext run = SpringApplication.run(SpringKafkaApplication.class, args);
		Producer messageProducer = run.getBean(Producer.class);
		MessageCreator messageCreator = run.getBean(MessageCreator.class);
		while(true) {
			String message = messageCreator.createMessage();
			messageProducer.sendMessage(message);
			Thread.sleep(2000);
		}

	}

}
