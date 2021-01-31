package application.configuration.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    @Value("${spring.rabbitmq.host}")
    private String rabbitHost;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue bombCompleteQueue() {
        return new Queue("bomb-complete-queue");
    }

    @Bean
    public FanoutExchange simpleBombExchange() {
        return new FanoutExchange("simple-bomb");
    }

    @Bean
    public FanoutExchange bombCompleteExchange() {
        return new FanoutExchange("bomb-complete");
    }

    @Bean
    public Binding bombQueueBindings(FanoutExchange bombCompleteExchange, Queue bombCompleteQueue) {
        return BindingBuilder.bind(bombCompleteQueue).to(bombCompleteExchange);
    }

}