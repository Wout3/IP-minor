package r0661554.project.taskmanager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import r0661554.project.taskmanager.domain.SubTask;
import r0661554.project.taskmanager.dto.SubTaskdto;
import r0661554.project.taskmanager.dto.Taskdto;
import r0661554.project.taskmanager.service.TaskService;


import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class TaskServiceTests {

    @Autowired
    private TaskService taskService;

    Taskdto Testdtos()
    {
        Taskdto taskdto = new Taskdto();

        taskdto.setTitel("test");
        taskdto.setDescription("testdesc");
        taskdto.setDueDate(LocalDateTime.of(2020,6, 30,12,36));
        taskdto.setId((long) 1);

        Taskdto taskdto1 = taskService.addTask(taskdto);
        return taskdto1;
    }

    @Test
    void testGetTaskdtos()
    {
        Taskdto taskdto = Testdtos();
        List<Taskdto> taskdtoList = taskService.getTaskdtos();

        assertNotNull(taskdtoList);
        assertFalse(taskdtoList.isEmpty());
        assertEquals(1, taskdtoList.size());
        Taskdto taskModelDTO1 = taskdtoList.get(0);
        assertNotNull(taskModelDTO1);
    }

    @Test
    @Transactional
    void testUpdateTask() {
        Taskdto taskdto = Testdtos();
        assertEquals("testdesc", taskdto.getDescription());


        taskdto.setDescription("updateddesc");

        taskdto = taskService.updateTask(taskdto);

        assertEquals("updateddesc", taskdto.getDescription());
    }

    @Test
    @Transactional
    void testGetTaskdto()
    {
        Taskdto taskdto = Testdtos();
        Taskdto taskdto1 = taskService.getTaskdto(taskdto.getId());
        assertEquals(taskdto.getDescription(), taskdto1.getDescription());
    }

    @Test
    @Transactional
    void testAddSubtask()
    {
        Taskdto taskdto = Testdtos();

        Taskdto subTask = new Taskdto();
        subTask.setTitel("subtest");
        subTask.setDescription("subdesc");

        System.out.println("tasks:  " + taskService.getTaskdtos().get(0).getId());

        taskService.addSubTask(subTask, taskdto.getId());

        taskdto = taskService.getTaskdto(taskdto.getId());

        assertNotNull(taskdto.getSubTasks());
        assertFalse(taskdto.getSubTasks().isEmpty());
        assertEquals(1, taskdto.getSubTasks().size());
        SubTaskdto subTaskdto = taskdto.getSubTasks().get(0);
        assertNotNull(subTaskdto);
    }


}
