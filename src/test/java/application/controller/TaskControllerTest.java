package application.controller;

import application.model.Task;
import application.producer.Producer;
import application.service.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
class TaskControllerTest {

    private final String INPUT = "{\"userId\":\"1\",\"platform\":\"Telegram\",\"userName\":\"1\",\"isPay\":true,\"phonenumbers\":[\"212312\"]}";
    private final String OUTPUT = "{\"id\":1,\"userId\":\"1\",\"userName\":\"1\",\"platform\":\"Telegram\",\"status\":\"CREATED\",\"isPay\":true,\"phonenumbers\":[{\"id\":1,\"number\":\"212312\"}]}";
    @Autowired
    private MockMvc mvc;
    @MockBean
    private TaskService taskServiceMock;
    @MockBean
    private Producer bombStartProducerMock;

    @Test
    public void createTaskTest() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        Mockito
                .when(
                        taskServiceMock.save(
                                objectMapper.readValue(INPUT, Task.class)
                        )
                )
                .thenReturn(
                        objectMapper.readValue(OUTPUT, Task.class)
                );

        mvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/tasks")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(INPUT)
                )
                .andExpect(
                        status().isOk()
                )
                .andExpect(
                        content().string(equalTo(OUTPUT))
                );
    }

}