package application.service;

import application.integration.producer.Producer;
import application.model.BannedPhonenumber;
import application.model.Phonenumber;
import application.model.Task;
import application.repository.BannedNumberRepository;
import application.repository.PayUserRepository;
import application.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;


@Slf4j
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final PayUserRepository payUserRepository;
    private final BannedNumberRepository bannedNumberRepository;
    private final Producer bombStartProducer;

    public TaskServiceImpl(TaskRepository taskRepository,
                           PayUserRepository payUserRepository,
                           BannedNumberRepository bannedNumberRepository,
                           Producer bombStartProducer
    ) {
        this.taskRepository = taskRepository;
        this.payUserRepository = payUserRepository;
        this.bannedNumberRepository = bannedNumberRepository;
        this.bombStartProducer = bombStartProducer;
    }

    @Override
    @Transactional
    public Task createTask(Task task) {

        log.info("Received task by {}", task.getUserId());

        if (task.getPhonenumbers().isEmpty()) {
            log.info("Task by {} is empty", task.getUserId());
            task.setMessage("Set some numbers");
            return task;
        }

        //todo send back banned numbers
        List<BannedPhonenumber> bannedNumbers = getBannedNumbers(task.getPhonenumbers());

        if (!bannedNumbers.isEmpty()) {
            log.info("Task by {} in banned numbers", task.getUserId());
            task.setMessage("This task has some banned numbers");
            return task;
        }

        task.setIsPay(isPayUser(task));

        if (isCanNotMultinumbers(task)) {
            log.info("Free task by {} has multinumbers feature", task.getUserId());
            task.setMessage("You use pay feature");
            return task;
        }

        log.info("Save task {}", task);

        Task save = taskRepository.saveAndFlush(task);

        //todo find place for this
        bombStartProducer.send(save);

        return save;
    }

    @Override
    @Transactional
    public Task updateStatus(Task task) {
        taskRepository.updateStatus(task.getId(), task.getStatus());

        return taskRepository.findById(task.getId()).get();
    }

    private List<BannedPhonenumber> getBannedNumbers(List<Phonenumber> phonenumbers) {
        return bannedNumberRepository.findAllById(
                phonenumbers
                        .stream()
                        .map(Phonenumber::getNumber)
                        .collect(toList())
        );
    }

    private boolean isPayUser(Task task) {
        return payUserRepository.findById(task.getUserId()).isPresent();
    }

    private boolean isCanNotMultinumbers(Task task) {

        return task.getPhonenumbers().size() > 1 && !task.getIsPay();
    }

}