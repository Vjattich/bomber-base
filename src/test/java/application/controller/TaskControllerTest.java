package application.controller;

import application.model.Task;
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

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TaskService taskServiceMock;

    @Test
    public void createTaskTest() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        String input = "{\"userId\":\"1\",\"platform\":\"Telegram\",\"userName\":\"1\",\"isPay\":true,\"phonenumbers\":[\"212312\"]}";
        String output = "{\"id\":1,\"userId\":\"1\",\"userName\":\"1\",\"platform\":\"Telegram\",\"status\":\"CREATED\",\"isPay\":true,\"phonenumbers\":[{\"id\":1,\"number\":\"212312\"}]}";

        Mockito
                .when(
                        taskServiceMock.createTask(
                                objectMapper.readValue(input, Task.class)
                        )
                )
                .thenReturn(
                        objectMapper.readValue(output, Task.class)
                );

        mvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/tasks")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(input)
                )
                .andExpect(
                        status().isOk()
                )
                .andExpect(
                        content().string(equalTo(output))
                );
    }

}