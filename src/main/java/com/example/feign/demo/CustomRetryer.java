package com.example.feign.demo;

import feign.Retryer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CustomRetryer extends Retryer.Default implements Retryer  {

    public CustomRetryer(@Value("${retry.delay}") Long delay,
                         @Value("${retry.maxAttempts}") Integer maxAttempts) {
        super(delay,delay,maxAttempts);
    }
}
