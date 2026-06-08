package sprinboot.trials.rabbitmq_trials.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sprinboot.trials.rabbitmq_trials.dtos.User;
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

    @PostMapping("/publishJson")
    public ResponseEntity<String> sendMessage(@RequestBody User user){
        producer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent to RabbitMQ");
    }
}
