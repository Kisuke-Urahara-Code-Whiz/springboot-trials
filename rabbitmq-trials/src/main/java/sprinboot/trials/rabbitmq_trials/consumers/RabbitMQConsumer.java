package sprinboot.trials.rabbitmq_trials.consumers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import sprinboot.trials.rabbitmq_trials.dtos.User;

@Service
public class RabbitMQConsumer {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.normal}"})
    public void consume(String message){
        logger.info("Message Received : {}",message);
    }

    @RabbitListener(queues = {"${rabbitmq.queue.json}"})
    public void consumeJson(User user){
        logger.info("Json received : {}", user.toString());
    }

}
