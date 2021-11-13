package com.ndemidov.spring_kafka.utils;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Scope("prototype")
public class RandomMessageCreator implements MessageCreator{
    private static final int MAX_LEN = 15;

    private final Random random = new Random();

    @Override
    public String createMessage() {
        int len = ((random.nextInt() % MAX_LEN) + MAX_LEN) % MAX_LEN;
        ++len;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0 ; i < len ; ++i) {
            int charShift = ((random.nextInt() % 26) + 26) % 26;
            char currentChar = (char) ('a' + charShift);
            stringBuilder.append(currentChar);
        }
        return stringBuilder.toString();
    }
}
