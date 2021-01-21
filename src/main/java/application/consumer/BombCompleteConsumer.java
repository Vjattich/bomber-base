package application.consumer;

import application.model.Task;
import application.service.TaskService;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class BombCompleteConsumer {

    private final TaskService taskService;

    public BombCompleteConsumer(TaskService taskService) {
        this.taskService = taskService;
    }

    @RabbitListener(queues = "bomb-complete-queue")
    public void onComplete(Task task) {
        taskService.save(task);
    }

}