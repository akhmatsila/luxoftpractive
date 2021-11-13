package com.ndemidov.spring_kafka;

import com.ndemidov.spring_kafka.utils.MessageCreator;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.protocol.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

@SpringBootTest(classes = {SpringKafkaApplication.class, KafkaTest.TestConfig.class})
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = {"listeners=PLAINTEXT://localhost:9093", "port=9093"
}
)
public class KafkaTest {

    @Autowired
    private WrapperConsumer con;

    @Autowired
    private MessageCreator messageCreator;

    @Autowired
    private Consumer consumer;

    @Autowired
    private Producer producer;

    @Value("${message.topic}")
    private String topic;

    @BeforeEach
    public void clearReceived() {
        con.received.clear();
    }


    @Test
    public void sendReceiveMessageTest() throws InterruptedException {
        for (int i = 0; i < 10; ++i) producer.sendMessage(messageCreator.createMessage());
        Thread.sleep(2000);
        Assertions.assertEquals(con.received.size(), 10);
    }

    @Test
    public void receivedMessageIdentity() throws InterruptedException {
        List<String> sentMessages = List.of("hello, world", "hi");
        sentMessages.forEach(producer::sendMessage);
        Thread.sleep(2000);
        Assertions.assertEquals(sentMessages, con.received);
    }

    @Test
    public void nonLatinMessageCheck() throws InterruptedException {
        String cyrillicMessage = "Привет, я сообщение с кириллицей";
        producer.sendMessage(cyrillicMessage);
        Thread.sleep(2000);
        Assertions.assertEquals(con.received.get(0), cyrillicMessage);
    }

    @Configuration
    public static class TestConfig {

        @Bean
        public static WrapperConsumer con() {
            return new WrapperConsumer();
        }
    }

    public static class WrapperConsumer implements BeanPostProcessor, Ordered {
        public final List<String> received = new ArrayList<>();

        @Override
        public int getOrder() {
            return Ordered.HIGHEST_PRECEDENCE;
        }

        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
        }

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            if (bean instanceof Consumer) {
                ProxyFactory factory = new ProxyFactory(bean);
                factory.setProxyTargetClass(true);
                factory.addAdvice(new MethodInterceptor() {
                    @Nullable
                    @Override
                    public Object invoke(@Nonnull MethodInvocation invocation) throws Throwable {
                        if (invocation.getMethod().getName().equals("acceptMessage")) {
                            Object[] args = invocation.getArguments();
                            ConsumerRecord<Integer, String> record = (ConsumerRecord<Integer, String>) args[0];
                            received.add(record.value());
                        }
                        return invocation.proceed();
                    }
                });
                return factory.getProxy();
            }
            return bean;
        }


    }


}
