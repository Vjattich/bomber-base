package application.controller;

import application.model.Task;
import application.producer.Producer;
import application.service.TaskService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    private final TaskService taskService;
    private final Producer bombStartProducer;

    private TaskController(TaskService taskService, Producer bombStartProducer) {
        this.taskService = taskService;
        this.bombStartProducer = bombStartProducer;
    }

    @PostMapping(value = "/tasks")
    public Task createTask(@RequestBody Task taskDTO) {
        Task task = taskService.save(taskDTO);
        //todo find place for this
        bombStartProducer.send(task);
        return task;
    }

}