package com.example.feign.demo;

import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;

public class MyErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        Exception exception = defaultErrorDecoder.decode(s, response);

        if(exception instanceof RetryableException){
            return exception;
        }

        if(response.status() == 504){
            return new RetryableException(200, "retry message",
                    response.request().httpMethod(),
                    null,
                    response.request());
        }
        return exception;
    }
}