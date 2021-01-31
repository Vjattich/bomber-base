package application.service;

import application.model.Phonenumber;
import application.model.Task;
import application.model.TaskStatus;
import application.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringJUnitConfig
class TaskServiceTest {

    private TaskService taskService;

    @MockBean
    private TaskRepository taskRepository;

    private static Stream<Arguments> saveTestArguments() {
        return Stream.of(
                Arguments.of(
                        new Task(null, "1", "1", "Telegram", TaskStatus.CREATED, null, Collections.singletonList(new Phonenumber("+79999999999")))
                ),
                Arguments.of(
                        new Task(null, "2", "2", "Telegram", TaskStatus.CREATED, null, Collections.singletonList(new Phonenumber("+79999999999")))
                )
        );
    }

    @BeforeEach
    private void setUp() {
        taskService = new TaskServiceImpl(taskRepository);
    }

    @ParameterizedTest
    @MethodSource("saveTestArguments")
    //todo complete
    //1. functionality of pay\not pay
    //2. correct checks
    public void saveTest(Task testTask) {

        assertDoesNotThrow(() -> {
            taskService.save(testTask);
        });

    }

}