package com.rebitMq.RebitMQ_TUT.controller;

import com.rebitMq.RebitMQ_TUT.dto.User;
import com.rebitMq.RebitMQ_TUT.publisher.RabbitMQJsonProducer;
import com.rebitMq.RebitMQ_TUT.publisher.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/vi")
public class MessageJsonController {


    private RabbitMQJsonProducer jsonProducer;

    public MessageJsonController(RabbitMQJsonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessagae(@RequestBody  User user){
        jsonProducer.sendJsonMessage(user);
        return  ResponseEntity.ok("json message send to rabbitMQ");

    }
}
