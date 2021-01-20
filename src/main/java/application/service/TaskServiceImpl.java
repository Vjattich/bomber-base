package application.service;

import application.model.Task;
import application.producer.Producer;
import application.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TaskServiceImpl implements TaskService {

    private final Producer taskProducer;
    private final TaskRepository taskRepository;

    public TaskServiceImpl(Producer bombStartProducer, TaskRepository taskRepository) {
        this.taskProducer = bombStartProducer;
        this.taskRepository = taskRepository;
    }

    @Override
    @Transactional
    //todo need decorate for sending
    public Task createTask(Task task) {

        Task save = taskRepository.save(task);

        taskProducer.send(save);

        return save;
    }

}
