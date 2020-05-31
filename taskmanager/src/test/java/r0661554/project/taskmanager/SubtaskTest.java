package r0661554.project.taskmanager;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import r0661554.project.taskmanager.domain.SubTask;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SubtaskTest {
    private SubTask subTask = new SubTask();

    @Test
    void testSetDescription()
    {
        subTask.setDescription("test");
        assertEquals("test", subTask.getDescription());
    }

    @Test
    void testSetTitel()
    {
        subTask.setTitel("test");
        assertEquals("test", subTask.getTitel());
    }
}
