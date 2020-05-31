package r0661554.project.taskmanager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import r0661554.project.taskmanager.domain.SubTask;
import r0661554.project.taskmanager.dto.SubTaskdto;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SubTaskdtoTest {

    private SubTaskdto subTaskdto = new SubTaskdto();

    @Test
    void testSetDescription()
    {
        subTaskdto.setDescription("test");
        assertEquals("test", subTaskdto.getDescription());
    }

    @Test
    void testSetTitel()
    {
        subTaskdto.setTitel("test");
        assertEquals("test", subTaskdto.getTitel());
    }

}
