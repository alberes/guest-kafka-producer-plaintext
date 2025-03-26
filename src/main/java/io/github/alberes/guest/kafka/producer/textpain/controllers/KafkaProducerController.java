package io.github.alberes.guest.kafka.producer.textpain.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.alberes.guest.kafka.producer.textpain.controllers.dto.GuestDto;
import io.github.alberes.guest.kafka.producer.textpain.services.GuestKafkaProduceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guests")
public class KafkaProducerController {

    @Autowired
    private GuestKafkaProduceService service;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping
    public ResponseEntity<Void> send(@RequestBody @Valid GuestDto dto){
        try {
            this.service.send(this.objectMapper.writeValueAsString(dto));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.created(null).build();
    }

}
