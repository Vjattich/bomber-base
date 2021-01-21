package application.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testConstructor() {
        assertEquals(TaskStatus.CREATED, (new Task()).getStatus());
    }

    @Test
    public void testConstructor2() {
        Task actualTask = new Task(123L, "42", "janedoe", "Platform", TaskStatus.CREATED, true,
                new ArrayList<Phonenumber>());
        assertEquals("janedoe", actualTask.getUserName());
        assertEquals("Platform", actualTask.getPlatform());
        assertEquals(123L, actualTask.getId().longValue());
        assertTrue(actualTask.getIsPay());
        assertEquals("42", actualTask.getUserId());
        assertEquals("Task(id=123, userId=42, userName=janedoe, platform=Platform, status=CREATED, isPay=true,"
                + " phonenumbers=[])", actualTask.toString());
        assertEquals(TaskStatus.CREATED, actualTask.getStatus());
    }

    @Test
    public void testEquals() {
        assertFalse((new Task()).equals("o"));
    }

    @Test
    public void testEquals10() {
        Task task = new Task();
        task.setStatus(null);
        assertFalse(task.equals(new Task()));
    }

    @Test
    public void testEquals11() {
        Task task = new Task();
        task.setPhonenumbers(new ArrayList<Phonenumber>());
        assertFalse(task.equals(new Task()));
    }

    @Test
    public void testEquals12() {
        Task task = new Task();
        task.setUserName("janedoe");
        assertFalse((new Task()).equals(task));
    }

    @Test
    public void testEquals13() {
        Task task = new Task();
        task.setUserId("42");
        assertFalse((new Task()).equals(task));
    }

    @Test
    public void testEquals14() {
        Task task = new Task();
        task.setStatus(null);
        assertFalse((new Task()).equals(task));
    }

    @Test
    public void testEquals15() {
        Task task = new Task();
        task.setPhonenumbers(new ArrayList<Phonenumber>());
        assertFalse((new Task()).equals(task));
    }

    @Test
    public void testEquals16() {
        Task task = new Task(123L, "42", "janedoe", "42", TaskStatus.CREATED, true, new ArrayList<Phonenumber>());
        assertFalse(task
                .equals(new Task(123L, "42", "janedoe", "Platform", TaskStatus.CREATED, true, new ArrayList<Phonenumber>())));
    }

    @Test
    public void testEquals17() {
        Task task = new Task(123L, "42", "janedoe", null, TaskStatus.CREATED, true, new ArrayList<Phonenumber>());
        assertFalse(task
                .equals(new Task(123L, "42", "janedoe", "Platform", TaskStatus.CREATED, true, new ArrayList<Phonenumber>())));
    }

    @Test
    public void testEquals2() {
        Task task = new Task();
        assertTrue(task.equals(new Task()));
    }

    @Test
    public void testEquals3() {
        Task o = new Task(123L, "42", "janedoe", "Platform", TaskStatus.CREATED, true, new ArrayList<Phonenumber>());
        assertFalse((new Task()).equals(o));
    }

    @Test
    public void testEquals4() {
        Task task = new Task(123L, "42", "janedoe", "Platform", TaskStatus.CREATED, true, new ArrayList<Phonenumber>());
        assertFalse(task.equals(new Task()));
    }

    @Test
    public void testEquals5() {
        Task task = new Task(123L, "42", "janedoe", "Platform", TaskStatus.CREATED, true, new ArrayList<Phonenumber>());
        assertTrue(task
                .equals(new Task(123L, "42", "janedoe", "Platform", TaskStatus.CREATED, true, new ArrayList<Phonenumber>())));
    }

    @Test
    public void testEquals6() {
        Task o = new Task(null, "42", "janedoe", "Platform", TaskStatus.CREATED, true, new ArrayList<Phonenumber>());
        assertFalse((new Task()).equals(o));
    }

    @Test
    public void testEquals7() {
        Task task = new Task();
        task.setUserName("janedoe");
        assertFalse(task.equals(new Task()));
    }

    @Test
    public void testEquals8() {
        Task task = new Task();
        task.setUserId("42");
        assertFalse(task.equals(new Task()));
    }

    @Test
    public void testEquals9() {
        Task task = new Task();
        task.setIsPay(true);
        assertFalse(task.equals(new Task()));
    }

    @Test
    public void testSetId() {
        Task task = new Task();
        task.setId(123L);
        assertEquals(123L, task.getId().longValue());
    }

    @Test
    public void testSetIsPay() {
        Task task = new Task();
        task.setIsPay(true);
        assertTrue(task.getIsPay());
    }

    @Test
    public void testSetPhonenumbers() {
        Task task = new Task();
        task.setPhonenumbers(new ArrayList<Phonenumber>());
        assertEquals(
                "Task(id=null, userId=null, userName=null, platform=null, status=CREATED, isPay=null," + " phonenumbers=[])",
                task.toString());
    }

    @Test
    public void testSetPlatform() {
        Task task = new Task();
        task.setPlatform("Platform");
        assertEquals("Platform", task.getPlatform());
    }

    @Test
    public void testSetStatus() {
        Task task = new Task();
        task.setStatus(TaskStatus.CREATED);
        assertEquals(TaskStatus.CREATED, task.getStatus());
    }

    @Test
    public void testSetUserId() {
        Task task = new Task();
        task.setUserId("42");
        assertEquals("42", task.getUserId());
    }

    @Test
    public void testSetUserName() {
        Task task = new Task();
        task.setUserName("janedoe");
        assertEquals("janedoe", task.getUserName());
    }

    @Test
    public void testToString() {
        assertEquals(
                "Task(id=null, userId=null, userName=null, platform=null, status=CREATED, isPay=null," + " phonenumbers=null)",
                (new Task()).toString());
    }
}

