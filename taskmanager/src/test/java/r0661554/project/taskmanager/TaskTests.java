package r0661554.project.taskmanager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import r0661554.project.taskmanager.domain.SubTask;
import r0661554.project.taskmanager.domain.Task;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TaskTests {
    private Task task = new Task();

    @Test
    void testSetDescription()
    {
        task.setDescription("test");
        assertEquals("test", task.getDescription());
    }

    @Test
    void testSetTitel()
    {
        task.setTitel("test");
        assertEquals("test", task.getTitel());
    }

    @Test
    void testSetID()
    {
        task.setId((long) 1);
        assertEquals((long) 1, task.getId());
    }

    @Test
    void testSetDueDate()
    {
        task.setDueDate(LocalDateTime.of(2020,6, 30,12,36));
        assertEquals((LocalDateTime.of(2020,6, 30,12,36)), task.getDueDate());
    }

    @Test
    void testSetSubTask()
    {
        SubTask subTask = new SubTask();
        task.addSubTask(subTask);
        assertEquals(1, task.getSubTasks().size());
    }

}
