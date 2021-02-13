package application.producer;

import application.model.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BombStartProducer implements Producer {

    private final RabbitTemplate template;

    public BombStartProducer(RabbitTemplate template) {
        this.template = template;
    }

    public void send(Task message) {
        log.info("send message {}", message);
        template.convertAndSend("simple-bomb", null, message);
    }

}
