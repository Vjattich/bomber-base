package application.producer;

import application.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


@SpringJUnitConfig
public class BombStartProducerTest {

    private Producer bombStartProducer;

    @MockBean
    private RabbitTemplate rabbitTemplateMock;

    @BeforeEach
    public void setUp() {
        this.bombStartProducer = new BombStartProducer(this.rabbitTemplateMock);
    }

    @Test
    public void testSend() {

        Task message = new Task();

        assertDoesNotThrow(() -> {
            bombStartProducer.send(message);
        });

        Mockito.verify(rabbitTemplateMock).convertAndSend(
                ArgumentMatchers.eq("simple-bomb"),
                ArgumentMatchers.isNull(),
                ArgumentMatchers.eq(message)
        );

    }

}