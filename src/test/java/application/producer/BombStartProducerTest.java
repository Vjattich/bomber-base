package application.producer;

import application.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


@SpringJUnitConfig
public class BombStartProducerTest {

    private Producer bombStartProducer;

    @MockBean
    private RabbitTemplate rabbitTemplateMock;

    private static Stream<Arguments> testSendArguments() {
        return Stream.of(
                Arguments.of(new Task(), "simple-bomb")
        );
    }

    @BeforeEach
    private void setUp() {
        this.bombStartProducer = new BombStartProducer(this.rabbitTemplateMock);
    }

    @ParameterizedTest
    @MethodSource("testSendArguments")
    //todo add functionality of change exchange name
    public void testSend(Task message, String exchangeName) {

        assertDoesNotThrow(() -> bombStartProducer.send(message));

        Mockito.verify(rabbitTemplateMock).convertAndSend(
                ArgumentMatchers.eq(exchangeName),
                ArgumentMatchers.isNull(),
                ArgumentMatchers.eq(message)
        );

    }

}