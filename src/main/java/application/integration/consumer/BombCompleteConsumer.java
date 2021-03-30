package application.integration.consumer;

import application.model.Task;
import application.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@EnableRabbit
public class BombCompleteConsumer {

    private final TaskService taskService;
    private final RestTemplate restTemplate;
    private final Map<String, String> platformMap;

    public BombCompleteConsumer(TaskService taskService,
                                RestTemplate restTemplate,
                                @Value("${module.telegram.url}") String telegramUrl) {
        this.taskService = taskService;
        this.restTemplate = restTemplate;
        this.platformMap = new HashMap<>();
        //todo need something smarter
        this.platformMap.put("TELEGRAM", telegramUrl);
    }

    @RabbitListener(queues = "bomb-complete-queue")
    public void onComplete(Task task) {

        log.info("Received task {}", task);

        Task save = taskService.updateStatus(task);

        String url = getModulePath(task) + "/answer";

        log.info("Send task {} to module {}", task.getId(), url);

        restTemplate.postForEntity(url, save, Task.class);
    }

    private String getModulePath(Task task) {
        return platformMap.get(task.getPlatform());
    }

}