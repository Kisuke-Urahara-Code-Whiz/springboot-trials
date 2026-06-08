package sprinboot.trials.rabbitmq_trials.producers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import sprinboot.trials.rabbitmq_trials.dtos.User;

//Spring Boot automatically configure RabbitTemplate for us. We just need to inject and use it.
@Service
public class RabbitMQProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.normal}")
    private String routingKeyName;

    @Value("${rabbitmq.routing.json}")
    private String jsonRoutingKey;

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQProducer.class);

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message){
        logger.info("Message sent -> {}", message);
        rabbitTemplate.convertAndSend(exchangeName, routingKeyName, message);
    }

    public void sendJsonMessage(User user){
        logger.info("Message sent -> {}", user.toString());
        rabbitTemplate.convertAndSend(exchangeName, jsonRoutingKey, user);
    }




}
