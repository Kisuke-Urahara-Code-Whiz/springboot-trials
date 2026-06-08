package sprinboot.trials.rabbitmq_trials.producers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//Spring Boot automatically configure RabbitTemplate for us. We just need to inject and use it.
@Service
public class RabbitMQProducer {

    @Value("${rabbitmq.exchangeName}")
    private String exchangeName;

    @Value("${rabbitmq.routingKeyName}")
    private String routingKeyName;

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQProducer.class);

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message){
        logger.info("Message sent -> {}", message);
        rabbitTemplate.convertAndSend(exchangeName, routingKeyName, message);
    }


}
