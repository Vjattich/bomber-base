package application.producer;

import application.model.Task;

public interface Producer {

    void send(Task message);

}