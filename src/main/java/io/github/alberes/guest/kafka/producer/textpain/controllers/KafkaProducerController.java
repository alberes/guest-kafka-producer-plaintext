package io.github.alberes.guest.kafka.producer.textpain.controllers;

import io.github.alberes.guest.kafka.producer.textpain.controllers.dto.GuestDto;
import io.github.alberes.guest.kafka.producer.textpain.services.GuestKafkaProduceService;
import io.github.alberes.guest.kafka.producer.textpain.utils.JsonUtils;
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
    private JsonUtils jsonUtils;

    @PostMapping
    public ResponseEntity<Void> send(@RequestBody @Valid GuestDto dto){
        this.service.send(jsonUtils.toJson(dto));
        return ResponseEntity.created(null).build();
    }

}
