package r0661554.project.taskmanager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import r0661554.project.taskmanager.domain.SubTask;
import r0661554.project.taskmanager.dto.SubTaskdto;
import r0661554.project.taskmanager.dto.Taskdto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TaskdtoTests {
    private Taskdto taskdto = new Taskdto();

    @Test
    void TestSetDescription()
    {
        taskdto.setDescription("test");
        assertEquals("test", taskdto.getDescription());
    }

    @Test
    void testSetTitel()
    {
        taskdto.setTitel("test");
        assertEquals("test", taskdto.getTitel());
    }

    @Test
    void testSetID()
    {
        taskdto.setId((long) 1);
        assertEquals((long) 1, taskdto.getId());
    }

    @Test
    void testSetDueDate()
    {
        taskdto.setDueDate(LocalDateTime.of(2020,6, 30,12,36));
        assertEquals((LocalDateTime.of(2020,6, 30,12,36)), taskdto.getDueDate());
    }

    @Test
    void testSetSubTaskList()
    {
        List<SubTaskdto> subtasks = new ArrayList<>();
        SubTaskdto subTask = new SubTaskdto();
        subtasks.add(subTask);
        taskdto.setSubTasksdto(subtasks);
        assertEquals(1, taskdto.getSubTasks().size());
    }

    @Test
    void testSetSubTask()
    {
        SubTaskdto subTask = new SubTaskdto();
        taskdto.addTask(subTask);
        assertEquals(1, taskdto.getSubTasks().size());
    }

}
