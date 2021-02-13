package application.service;

import application.model.*;
import application.repository.BannedNumberRepository;
import application.repository.PayUserRepository;
import application.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@SpringJUnitConfig
class TaskServiceTest {

    private TaskService taskService;

    @MockBean
    private TaskRepository taskRepository;

    @MockBean
    private PayUserRepository payUserRepository;

    @MockBean
    private BannedNumberRepository bannedNumberRepository;

    private static Stream<Arguments> saveTestArguments() {
        return Stream.of(
                Arguments.of(
                        new Task(null, "1", "1", "Telegram", TaskStatus.CREATED, null, List.of(new Phonenumber("79999999999")), null),
                        new Task(1L, "1", "1", "Telegram", TaskStatus.CREATED, true, List.of(new Phonenumber(1L, "79999999999", null)), null)
                ),
                Arguments.of(
                        new Task(null, "1", "1", "Telegram", TaskStatus.CREATED, null, List.of(new Phonenumber("79999999999"), new Phonenumber("79999999991")), null),
                        new Task(1L, "1", "1", "Telegram", TaskStatus.CREATED, true, List.of(new Phonenumber(1L, "79999999999", null), new Phonenumber(2L, "79999999991", null)), null)
                ),
                Arguments.of(
                        new Task(null, "2", "2", "Telegram", TaskStatus.CREATED, null, List.of(new Phonenumber("79999999999")), null),
                        new Task(1L, "2", "2", "Telegram", TaskStatus.CREATED, false, List.of(new Phonenumber(1L, "79999999999", null)), null)
                ),
                Arguments.of(
                        new Task(null, "1", "1", "Telegram", TaskStatus.CREATED, null, List.of(new Phonenumber("79989981122")), null),
                        new Task(null, "1", "1", "Telegram", TaskStatus.CREATED, null, List.of(new Phonenumber("79989981122")), "This task has some banned numbers")
                ),
                Arguments.of(
                        new Task(null, "2", "2", "Telegram", TaskStatus.CREATED, null, List.of(new Phonenumber("79999999999"), new Phonenumber("79999999991")), null),
                        new Task(null, "2", "2", "Telegram", TaskStatus.CREATED, false, List.of(new Phonenumber("79999999999"), new Phonenumber(null, "79999999991", null)), "You use pay feature")
                )
        );
    }

    @BeforeEach
    private void setUp() {
        taskService = new TaskServiceImpl(taskRepository, payUserRepository, bannedNumberRepository);

        AtomicLong taskIdCounter = new AtomicLong();
        AtomicLong numberIdCounter = new AtomicLong();

        Mockito.doAnswer(invocationOnMock -> {
            Task task = invocationOnMock.getArgument(0, Task.class);
            task.setId(taskIdCounter.incrementAndGet());

            for (Phonenumber phonenumber : task.getPhonenumbers()) {
                phonenumber.setId(numberIdCounter.incrementAndGet());
            }

            return task;
        }).when(taskRepository).save(any(Task.class));

        Mockito.when(bannedNumberRepository.findAllById(Collections.singletonList("79989981122"))).thenReturn(
                List.of(new BannedPhonenumber("79989981122"))
        );

        Mockito.when(bannedNumberRepository.findAllById(Collections.singletonList("79999999999"))).thenReturn(
                Collections.emptyList()
        );

        Mockito.when(payUserRepository.findById("1")).thenReturn(
                Optional.of(new PayUser("1"))
        );

        Mockito.when(payUserRepository.findById("2")).thenReturn(
                Optional.empty()
        );

    }

    @ParameterizedTest
    @MethodSource("saveTestArguments")
    //todo complete
    //1. set status
    //2. correct number?
    public void saveTest(Task input, Task output) {

        assertEquals(output, taskService.save(input));

    }

}