package sprinboot.trials.rabbitmq_trials.configs;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queueName}")
    private String queueName;

    @Value("${rabbitmq.exchangeName}")
    private String exchangeName;

    @Value("${rabbitmq.routingKeyName}")
    private String routingKeyName;

    @Bean
    public Queue createQueue(){
        return new Queue(queueName,true);
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

    //RabbitTemplate
    //ConnectionFactory
    //RabbitAdmin
    //Infrastructure beans @SpringBootApplication auto-configures
}
