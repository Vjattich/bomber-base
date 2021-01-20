package application.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class BombStartProducer implements Producer {

    private final RabbitTemplate template;

    public BombStartProducer(RabbitTemplate template) {
        this.template = template;
    }

    public void send(Object message) {
        template.convertAndSend("simple-bomb", null, message);
    }

}
