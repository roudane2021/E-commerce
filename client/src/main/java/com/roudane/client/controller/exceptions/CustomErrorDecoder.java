package com.roudane.client.controller.exceptions;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();
    @Override
    public Exception decode(String s, Response response) {
        if (response.status() == 400) {
            return new ProductNotFoundException("Requête incorrecte");
        }
        return defaultErrorDecoder.decode(s, response);
    }
}
