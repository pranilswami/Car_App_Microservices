//package com.car_app.payment_service.payment_service.config;
//
//import com.car_app.payment_service.payment_service.payload.PaymentEvent;
//import org.apache.kafka.clients.admin.NewTopic;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.config.TopicBuilder;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//import org.springframework.kafka.support.serializer.JsonSerializer;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class KafkaProducerConfig {
//
//    @Bean
//    public ProducerFactory<String, PaymentEvent> producerFactory() {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);  // ✅ Ensure JSON serialization
//
//        return new DefaultKafkaProducerFactory<>(configProps);
//    }
//
//    @Bean
//    public KafkaTemplate<String, PaymentEvent> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
//
//    @Bean
//    public NewTopic topic(){
//        return TopicBuilder
//                .name(AppConstants.PAYMENT_TOPIC_NAME)
//                .build();
//    }
//}
//
