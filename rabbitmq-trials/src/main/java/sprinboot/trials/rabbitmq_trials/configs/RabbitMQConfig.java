package sprinboot.trials.rabbitmq_trials.configs;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queue.normal}")
    private String queueName;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.normal}")
    private String routingKeyName;

    @Value("${rabbitmq.queue.json}")
    private String jsonQueue;

    @Value("${rabbitmq.routing.json}")
    private String jsonRoutingKeyName;

    @Bean
    public Queue createQueue(){
        return new Queue(queueName,true);
    }

    @Bean
    public Queue createJsonQueue(){
        return new Queue(jsonQueue, true);
    }

    @Bean
    public TopicExchange createTopicExchange(){
        return new TopicExchange(exchangeName);
    }

    @Bean
    public Binding createBinding(){
        return BindingBuilder
                .bind(createQueue())
                .to(createTopicExchange())
                .with(routingKeyName);
    }

    @Bean
    public Binding createJsonBinding(){
        return BindingBuilder
                .bind(createJsonQueue())
                .to(createTopicExchange())
                .with(jsonRoutingKeyName);
    }

    //Json messages need serialization
    @Bean
    public MessageConverter converter(){
        return new JacksonJsonMessageConverter();
    }

    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

    //RabbitTemplate
    //ConnectionFactory
    //RabbitAdmin
    //Infrastructure beans @SpringBootApplication auto-configures
}
