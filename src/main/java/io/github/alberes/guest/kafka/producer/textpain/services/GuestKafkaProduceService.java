package io.github.alberes.guest.kafka.producer.textpain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class GuestKafkaProduceService {

    @Value("${spring.kafka.producer.topic}")
    private String guestTopic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message){
        this.kafkaTemplate.send(this.guestTopic, message);
        System.out.println("Sent message: " + message);
    }

}
