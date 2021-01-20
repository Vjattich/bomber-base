package application.consumer;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class BombCompleteConsumer {

    @RabbitListener(queues = "bomb-complete-queue")
    public void onComplete(String message) {
        System.out.println(message);
    }

}