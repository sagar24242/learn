package com.rebitMq.RebitMQ_TUT.publisher;

import com.rebitMq.RebitMQ_TUT.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQJsonProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.json.key}")
    private String routingJsonKey;


    private RabbitTemplate rabbitTemplate;

    private  static  final Logger LOGGER= LoggerFactory.getLogger(RabbitMQJsonProducer.class);

    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public  void sendJsonMessage(User user){
     LOGGER.info(String.format("json message send ->%s", user.toString()));
     rabbitTemplate.convertAndSend(exchange,routingJsonKey,user);
    }
}
