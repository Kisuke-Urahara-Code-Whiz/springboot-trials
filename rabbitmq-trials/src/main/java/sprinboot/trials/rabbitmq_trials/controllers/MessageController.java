package sprinboot.trials.rabbitmq_trials.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sprinboot.trials.rabbitmq_trials.producers.RabbitMQProducer;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final RabbitMQProducer producer;

    MessageController(RabbitMQProducer producer){
        this.producer = producer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        producer.sendMessage(message);
        return new ResponseEntity<>("Message Sent to RabbitMQ...", HttpStatus.OK);
    }
}
