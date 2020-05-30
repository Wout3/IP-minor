package r0661554.project.taskmanager.service;

import r0661554.project.taskmanager.domain.Task;
import r0661554.project.taskmanager.dto.Taskdto;

import java.util.List;

public interface TaskService {
    public List<Taskdto> getTaskdtos();

    void addTask(Taskdto taskdto);

    void addSubTask(Taskdto taskdto, Long id);

    Taskdto getTaskdto(Long id);

    //Task getTask(Long id);

    Taskdto updateTask(Taskdto taskdto);

    Long getVolgendeId();
}
