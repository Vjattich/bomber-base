package application.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    @Test
    public void testCanEqual() {
        assertFalse((new Task()).canEqual("other"));
    }

    @Test
    public void testCanEqual2() {
        Task task = new Task();

        Task task1 = new Task();
        task1.setMessage("Not all who wander are lost");
        task1.setUserName("janedoe");
        task1.setUserId("42");
        task1.setId(123L);
        task1.setIsPay(true);
        task1.setStatus(TaskStatus.CREATED);
        task1.setPlatform("Platform");
        task1.setPhonenumbers(new ArrayList<Phonenumber>());
        assertTrue(task.canEqual(task1));
    }

    @Test
    public void testConstructor() {
        assertEquals(TaskStatus.CREATED, (new Task()).getStatus());
    }

    @Test
    public void testConstructor2() {
        Task actualTask = new Task(123L, "42", "janedoe", "Platform", TaskStatus.CREATED, true,
                new ArrayList<Phonenumber>(), "Not all who wander are lost");
        assertEquals("janedoe", actualTask.getUserName());
        assertEquals("Platform", actualTask.getPlatform());
        assertEquals(123L, actualTask.getId().longValue());
        assertTrue(actualTask.getIsPay());
        assertEquals("42", actualTask.getUserId());
        assertEquals("Not all who wander are lost", actualTask.getMessage());
        assertEquals(
                "Task(id=123, userId=42, userName=janedoe, platform=Platform, status=CREATED, isPay=true, phonenumbers=[],"
                        + " message=Not all who wander are lost)",
                actualTask.toString());
        assertEquals(TaskStatus.CREATED, actualTask.getStatus());
    }

    @Test
    public void testEquals() {
        assertFalse((new Task()).equals("o"));
    }

    @Test
    public void testEquals10() {
        Task task = new Task(123L, "42", "janedoe", "42", TaskStatus.CREATED, true, new ArrayList<Phonenumber>(),
                "Not all who wander are lost");

        Task task1 = new Task();
        task1.setMessage("Not all who wander are lost");
        task1.setUserName("janedoe");
        task1.setUserId("42");
        task1.setId(123L);
        task1.setIsPay(true);
        task1.setStatus(TaskStatus.CREATED);
        task1.setPlatform("Platform");
        task1.setPhonenumbers(new ArrayList<Phonenumber>());
        assertFalse(task.equals(task1));
    }

    @Test
    public void testEquals11() {
        Task task = new Task(123L, "42", "janedoe", null, TaskStatus.CREATED, true, new ArrayList<Phonenumber>(),
                "Not all who wander are lost");

        Task task1 = new Task();
        task1.setMessage("Not all who wander are lost");
        task1.setUserName("janedoe");
        task1.setUserId("42");
        task1.setId(123L);
        task1.setIsPay(true);
        task1.setStatus(TaskStatus.CREATED);
        task1.setPlatform("Platform");
        task1.setPhonenumbers(new ArrayList<Phonenumber>());
        assertFalse(task.equals(task1));
    }

    @Test
    public void testEquals12() {
        Task task = new Task(123L, "42", "janedoe", "Platform", null, true, new ArrayList<Phonenumber>(),
                "Not all who wander are lost");

        Task task1 = new Task();
        task1.setMessage("Not all who wander are lost");
        task1.setUserName("janedoe");
        task1.setUserId("42");
        task1.setId(123L);
        task1.setIsPay(true);
        task1.setStatus(TaskStatus.CREATED);
        task1.setPlatform("Platform");
        task1.setPhonenumbers(new ArrayList<Phonenumber>());
        assertFalse(task.equals(task1));
    }

    @Test
    public void testEquals13() {
        Task task = new Task(123L, "42", "janedoe", "Platform", TaskStatus.RUNNING, true, new ArrayList<Phonenumber>(),
                "Not all who wander are lost");

        Task task1 = new Task();
        task1.setMessage("Not all who wander are lost");
        task1.setUserName("janedoe");
        task1.setUserId("42");
        task1.setId(123L);
        task1.setIsPay(true);
        task1.setStatus(TaskStatus.CREATED);
        task1.setPlatform("Platform");
        task1.setPhonenumbers(new ArrayList<Phonenumber>());
        assertFalse(task.equals(task1));
    }

    @Test
    public void testEquals14() {
        Task task = new Task(123L, "42", "janedoe", "Platform", TaskStatus.CREATED, false, new ArrayList<Phonenumber>(),
                "Not all who wander are lost");

        Task task1 = new Task();
        task1.setMessage("Not all who wander are lost");
        task1.setUserName("janedoe");
        task1.setUserId("42");
        task1.setId(123L);
        task1.setIsPay(true);
        task1.setStatus(TaskStatus.CREATED);
        task1.setPlatform("Platform");
        task1.setPhonenumbers(new ArrayList<Phonenumber>());
        assertFalse(task.equals(task1));
    }

    @Test
    public void testEquals15() {
        Task task = new Task();
        task.setMessage("Not all who wander are lost");
        task.setUserName("janedoe");
        task.setUserId("42");
        task.setId(123L);
        task.setIsPay(true);
        task.setStatus(null);
        task.setPlatform("42");
        task.setPhonenumbers(new ArrayList<Phonenumber>());

        Phonenumber phonenumber = new Phonenumber();
        phonenumber.setNumber("42");
        phonenumber.setId(123L);
        phonenumber.setTask(task);

        ArrayList<Phonenumber> phonenumberList = new ArrayList<Phonenumber>();
        phonenumberList.add(phonenumber);
        Task task1 = new Task(123L, "42", "janedoe", "Platform", TaskStatus.CREATED, true, phonenumberList,
                "Not all who wander are lost");

        Task task2 = new Task();
        task2.setMessage("Not all who wander are lost");
        task2.setUserName("janedoe");
        task2.setUserId("42");
        task2.setId(123L);
        task2.setIsPay(true);
        task2.setStatus(TaskStatus.CREATED);
        task2.setPlatform("Platform");
        task2.setPhonenumbers(new ArrayList<Phonenumber>());
        assertFalse(task1.equals(task2));
    }

    @Test
    public void testEquals16() {
        Task task = new Task(123L, "42", "janedoe", "Platform", TaskStatus.CREATED, true, new ArrayList<Phonenumber>(),
                "42");

        Task task1 = new Task();
        task1.setMessage("Not all who wander are lost");
        task1.setUserName("janedoe");
        task1.setUserId("42");
        task1.setId(123L);
        task1.setIsPay(true);
        task1.setStatus(TaskStatus.CREATED);
        task1.setPlatform("Platform");
        task1.setPhonenumbers(new ArrayList<Phonenumber>());
        assertFalse(task.equals(task1));
    }

    @Test
    public void testEquals17() {
        Task task = new Task(123L, "42", "janedoe", "Platform", TaskStatus.CREATED, true, new ArrayList<Phonenumber>(),
                null);

        Task task1 = new Task();
        task1.setMessage("Not all who wander are lost");
        task1.setUserName("janedoe");
        task1.setUserId("42");
        task1.setId(123L);
        task1.setIsPay(true);
        task1.setStatus(TaskStatus.CREATED);
        task1.setPlatform("Platform");
        task1.setPhonenumbers(new ArrayList<Phonenumber>());
        assertFalse(task.equals(task1));
    }

    @Test
    public void testEquals18() {
        Task task = new Task();

        Task task1 = new Task();
        task1.setMessage("Not all who wander are lost");
        task1.setUserName("janedoe");
        task1.setUserId("42");
        task1.setId(null);
        task1.setIsPay(null);
        task1.setStatus(TaskStatus.CREATED);
        task1.setPlatform("Platform");
        task1.setPhonenumbers(new ArrayList<Phonenumber>());
        assertFalse(task.equals(task1));
    }

    @Test
    public void testEquals2() {
        Task task = new Task();

        Task task1 = new Task();
        task1.setMessage("Not all who wander are lost");
        task1.setUserName("janedoe");
        task1.setUserId("42");
        task1.setId(123L);
        task1.setIsPay(true);
        task1.setStatus(TaskStatus.CREATED);
        task1.setPlatform("Platform");
        task1.setPhonenumbers(new ArrayList<Phonenumber>());
        assertFalse(task.equals(task1));
    }

    @Test
    public void testEquals3() {
        Task task = new Task(123L, "42", "janedoe", "Platform", TaskStatus.CREATED, true, new ArrayList<Phonenumber>(),
                "Not all who wander are lost");

        Task task1 = new Task();
        task1.setMessage("Not all who wander are lost");
        task1.setUserName("janedoe");
        task1.setUserId("42");
        task1.setId(123L);
        task1.setIsPay(true);
        task1.setStatus(TaskStatus.CREATED);
        task1.setPlatform("Platform");
        task1.setPhonenumbers(new ArrayList<Phonenumber>());
        assertTrue(task.equals(task1));
    }

    @Test
    public void testEquals4() {
        Task task = new Task();

        Task task1 = new Task();
        task1.setMessage("Not all who wander are lost");
        task1.setUserName("janedoe");
        task1.setUserId("42");
        task1.setId(null);
        task1.setIsPay(true);
        task1.setStatus(TaskStatus.CREATED);
        task1.setPlatform("Platform");
        task1.setPhonenumbers(new ArrayList<Phonenumber>());
        assertFalse(task.equals(task1));
    }

    @Test
    public void testEquals5() {
        Task task = new Task(0L, "42", "janedoe", "Platform", TaskStatus.CREATED, true, new ArrayList<Phonenumber>(),
                "Not all who wander are lost");

        Task task1 = new Task();
        task1.setMessage("Not all who wander are lost");
        task1.setUserName("janedoe");
        task1.setUserId("42");
        task1.setId(123L);
        task1.setIsPay(true);
        task1.setStatus(TaskStatus.CREATED);
        task1.setPlatform("Platform");
        task1.setPhonenumbers(new ArrayList<Phonenumber>());
        assertFalse(task.equals(task1));
    }

    @Test
    public void testEquals6() {
        Task task = new Task(123L, null, "janedoe", "Platform", TaskStatus.CREATED, true, new ArrayList<Phonenumber>(),
                "Not all who wander are lost");

        Task task1 = new Task();
        task1.setMessage("Not all who wander are lost");
        task1.setUserName("janedoe");
        task1.setUserId("42");
        task1.setId(123L);
        task1.setIsPay(true);
        task1.setStatus(TaskStatus.CREATED);
        task1.setPlatform("Platform");
        task1.setPhonenumbers(new ArrayList<Phonenumber>());
        assertFalse(task.equals(task1));
    }

    @Test
    public void testEquals7() {
        Task task = new Task(123L, "janedoe", "janedoe", "Platform", TaskStatus.CREATED, true, new ArrayList<Phonenumber>(),
                "Not all who wander are lost");

        Task task1 = new Task();
        task1.setMessage("Not all who wander are lost");
        task1.setUserName("janedoe");
        task1.setUserId("42");
        task1.setId(123L);
        task1.setIsPay(true);
        task1.setStatus(TaskStatus.CREATED);
        task1.setPlatform("Platform");
        task1.setPhonenumbers(new ArrayList<Phonenumber>());
        assertFalse(task.equals(task1));
    }

    @Test
    public void testEquals8() {
        Task task = new Task(123L, "42", "42", "Platform", TaskStatus.CREATED, true, new ArrayList<Phonenumber>(),
                "Not all who wander are lost");

        Task task1 = new Task();
        task1.setMessage("Not all who wander are lost");
        task1.setUserName("janedoe");
        task1.setUserId("42");
        task1.setId(123L);
        task1.setIsPay(true);
        task1.setStatus(TaskStatus.CREATED);
        task1.setPlatform("Platform");
        task1.setPhonenumbers(new ArrayList<Phonenumber>());
        assertFalse(task.equals(task1));
    }

    @Test
    public void testEquals9() {
        Task task = new Task(123L, "42", null, "Platform", TaskStatus.CREATED, true, new ArrayList<Phonenumber>(),
                "Not all who wander are lost");

        Task task1 = new Task();
        task1.setMessage("Not all who wander are lost");
        task1.setUserName("janedoe");
        task1.setUserId("42");
        task1.setId(123L);
        task1.setIsPay(true);
        task1.setStatus(TaskStatus.CREATED);
        task1.setPlatform("Platform");
        task1.setPhonenumbers(new ArrayList<Phonenumber>());
        assertFalse(task.equals(task1));
    }

//    @Test
//    public void testHashCode() {
//        assertEquals(-791086271, (new Task()).hashCode());
//        assertEquals(1113776427, (new Task(123L, "42", "janedoe", "Platform", TaskStatus.CREATED, true,
//                new ArrayList<Phonenumber>(), "Not all who wander are lost")).hashCode());
//    }

    @Test
    public void testHashCode2() {
        Task task = new Task();
        task.setStatus(null);
        assertEquals(-506892431, task.hashCode());
    }

//    @Test
//    public void testHashCode3() {
//        Task task = new Task();
//        task.setMessage("Not all who wander are lost");
//        task.setUserName("janedoe");
//        task.setUserId("42");
//        task.setId(123L);
//        task.setIsPay(true);
//        task.setStatus(null);
//        task.setPlatform(null);
//        task.setPhonenumbers(new ArrayList<Phonenumber>());
//
//        Phonenumber phonenumber = new Phonenumber();
//        phonenumber.setNumber(null);
//        phonenumber.setId(123L);
//        phonenumber.setTask(task);
//
//        ArrayList<Phonenumber> phonenumberList = new ArrayList<Phonenumber>();
//        phonenumberList.add(phonenumber);
//        assertEquals(-1103497605, (new Task(123L, "42", "janedoe", "Platform", TaskStatus.CREATED, true, phonenumberList,
//                "Not all who wander are lost")).hashCode());
//    }

//    @Test
//    public void testHashCode4() {
//        Task task = new Task();
//        task.setMessage("Not all who wander are lost");
//        task.setUserName("janedoe");
//        task.setUserId("42");
//        task.setId(123L);
//        task.setIsPay(true);
//        task.setStatus(null);
//        task.setPlatform(null);
//        task.setPhonenumbers(new ArrayList<Phonenumber>());
//
//        Phonenumber phonenumber = new Phonenumber();
//        phonenumber.setNumber(null);
//        phonenumber.setId(123L);
//        phonenumber.setTask(task);
//
//        Task task1 = new Task();
//        task1.setMessage("Not all who wander are lost");
//        task1.setUserName("janedoe");
//        task1.setUserId("42");
//        task1.setId(123L);
//        task1.setIsPay(true);
//        task1.setStatus(null);
//        task1.setPlatform(null);
//        task1.setPhonenumbers(new ArrayList<Phonenumber>());
//
//        Phonenumber phonenumber1 = new Phonenumber();
//        phonenumber1.setNumber(null);
//        phonenumber1.setId(123L);
//        phonenumber1.setTask(task1);
//
//        ArrayList<Phonenumber> phonenumberList = new ArrayList<Phonenumber>();
//        phonenumberList.add(phonenumber1);
//        phonenumberList.add(phonenumber);
//        assertEquals(-1119515861, (new Task(123L, "42", "janedoe", "Platform", TaskStatus.CREATED, true, phonenumberList,
//                "Not all who wander are lost")).hashCode());
//    }

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
    public void testSetMessage() {
        Task task = new Task();
        task.setMessage("Not all who wander are lost");
        assertEquals("Not all who wander are lost", task.getMessage());
    }

    @Test
    public void testSetPhonenumbers() {
        Task task = new Task();
        task.setPhonenumbers(new ArrayList<Phonenumber>());
        assertEquals("Task(id=null, userId=null, userName=null, platform=null, status=CREATED, isPay=null, phonenumbers=[],"
                + " message=null)", task.toString());
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
                "Task(id=null, userId=null, userName=null, platform=null, status=CREATED, isPay=null, phonenumbers=null,"
                        + " message=null)",
                (new Task()).toString());
    }

    @Test
    public void testToString2() {
        Task task = new Task();
        task.setMessage("Not all who wander are lost");
        task.setUserName("janedoe");
        task.setUserId("42");
        task.setId(123L);
        task.setIsPay(true);
        task.setStatus(TaskStatus.CREATED);
        task.setPlatform("Platform");
        task.setPhonenumbers(new ArrayList<Phonenumber>());

        Phonenumber phonenumber = new Phonenumber();
        phonenumber.setNumber("Number");
        phonenumber.setId(123L);
        phonenumber.setTask(task);

        ArrayList<Phonenumber> phonenumberList = new ArrayList<Phonenumber>();
        phonenumberList.add(phonenumber);

        Task task1 = new Task();
        task1.setPhonenumbers(phonenumberList);
        assertEquals(
                "Task(id=null, userId=null, userName=null, platform=null, status=CREATED, isPay=null, phonenumbers="
                        + "[Phonenumber(id=123, number=Number, task=Task(id=123, userId=42, userName=janedoe, platform=Platform,"
                        + " status=CREATED, isPay=true, phonenumbers=[], message=Not all who wander are lost))], message=null)",
                task1.toString());
    }

    @Test
    public void testToString3() {
        Task task = new Task();
        task.setMessage("Not all who wander are lost");
        task.setUserName("janedoe");
        task.setUserId("42");
        task.setId(123L);
        task.setIsPay(true);
        task.setStatus(TaskStatus.CREATED);
        task.setPlatform("Platform");
        task.setPhonenumbers(new ArrayList<Phonenumber>());

        Phonenumber phonenumber = new Phonenumber();
        phonenumber.setNumber("Number");
        phonenumber.setId(123L);
        phonenumber.setTask(task);

        Task task1 = new Task();
        task1.setMessage("Not all who wander are lost");
        task1.setUserName("janedoe");
        task1.setUserId("42");
        task1.setId(123L);
        task1.setIsPay(true);
        task1.setStatus(TaskStatus.CREATED);
        task1.setPlatform("Task(id=");
        task1.setPhonenumbers(new ArrayList<Phonenumber>());

        Phonenumber phonenumber1 = new Phonenumber();
        phonenumber1.setNumber("Task(id=");
        phonenumber1.setId(123L);
        phonenumber1.setTask(task1);

        ArrayList<Phonenumber> phonenumberList = new ArrayList<Phonenumber>();
        phonenumberList.add(phonenumber1);
        phonenumberList.add(phonenumber);

        Task task2 = new Task();
        task2.setPhonenumbers(phonenumberList);
        assertEquals("Task(id=null, userId=null, userName=null, platform=null, status=CREATED, isPay=null, phonenumbers="
                + "[Phonenumber(id=123, number=Task(id=, task=Task(id=123, userId=42, userName=janedoe, platform=Task(id=,"
                + " status=CREATED, isPay=true, phonenumbers=[], message=Not all who wander are lost)), Phonenumber(id=123,"
                + " number=Number, task=Task(id=123, userId=42, userName=janedoe, platform=Platform, status=CREATED,"
                + " isPay=true, phonenumbers=[], message=Not all who wander are lost))], message=null)", task2.toString());
    }
}

