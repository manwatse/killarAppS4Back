package models;

import org.junit.Test;

public class TaskTest {

        @Test
    public void TestConstructor() {
        Task task = new Task(1, "test", "test");

        assertEquals(task.getName(), "test");
        assertEquals(task.getDescription(), "test");
    }

}