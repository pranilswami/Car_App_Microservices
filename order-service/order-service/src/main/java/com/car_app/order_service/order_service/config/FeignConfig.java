package com.car_app.order_service.order_service.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public Encoder feignEncoder() {
        return new JacksonEncoder(new ObjectMapper());
    }

    @Bean
    public Decoder feignDecoder() {
        return new JacksonDecoder(new ObjectMapper());
    }
}