package application.controller;

import application.model.Task;
import application.service.TaskService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    private final TaskService taskService;

    private TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(value = "/tasks")
    public Task createTask(@RequestBody Task taskDTO) {
        return taskService.createTask(taskDTO);
    }

}