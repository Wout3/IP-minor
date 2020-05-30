package r0661554.project.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import r0661554.project.taskmanager.domain.SubTask;
import r0661554.project.taskmanager.domain.Task;
import r0661554.project.taskmanager.dto.SubTaskdto;
import r0661554.project.taskmanager.dto.Taskdto;
import r0661554.project.taskmanager.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private final TaskRepository repository;

    @Autowired
    public TaskServiceImpl(TaskRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Taskdto> getTaskdtos(){
        List<Taskdto> taskdtos = new ArrayList<>();
        for (Task task: repository.findAll()) {
            Taskdto taskdto = convert(task);
            taskdtos.add(taskdto);
        }
        return taskdtos;
    }

    @Override
    public void addTask(Taskdto taskdto){
        Task task = convertToTask(taskdto);
        repository.save(task);
    }

    @Override
    public void addSubTask(Taskdto taskdto, Long id){
        SubTask subtask = new SubTask(taskdto.getDescription(),taskdto.getTitel());
        Task task = this.repository.getOne(id);
        task.addSubTask(subtask);
        this.repository.save(task);
        //this.repository.getTasks().get(id).addSubTask(subtask);
        System.out.println("task added");
    }

    /*@Override
    public Task getTask(Long id) {
        List<Taskdto> tasks = getTaskdtos();
        return convertToTask(repository.(id));
    }*/

    @Override
    public Taskdto getTaskdto(Long id) {
        return convert(repository.getOne(id));
    }

    @Override
    public Taskdto updateTask(Taskdto taskdto) {
        Task task = convertToTask(taskdto);
        repository.deleteById(taskdto.getId());
        task = repository.save(task);
        return convert(task);
    }

    @Override
    public Long getVolgendeId() {
        List<Task> tasks = repository.findAll();
        if (tasks.size() == 0) return Long.valueOf(1);
        long hoogsteId = 0;
        for (Task t: tasks) {
            if (t.getId() > hoogsteId) hoogsteId = t.getId();
        }
        return ++hoogsteId;
    }

    public Taskdto convert(Task task)
    {
        Taskdto dto = new Taskdto();
        dto.setId(task.getId());
        dto.setTitel(task.getTitel());
        dto.setDueDate(task.getDueDate());
        dto.setDescription(task.getDescription());
        List<SubTaskdto> subtaskdtos = new ArrayList<>();
        for (SubTask t: task.getSubTasks()) {
            SubTaskdto subtaskdto = new SubTaskdto();
            subtaskdto.setId(t.getId());
            subtaskdto.setDescription(t.getDescription());
            subtaskdto.setTitel(t.getTitel());
            subtaskdtos.add(subtaskdto);
        }
        dto.setSubTasksdto(subtaskdtos);
        return dto;
    }

    public Task convertToTask(Taskdto taskdto)
    {
        Task task = new Task();
        task.setTitel(taskdto.getTitel());
        task.setDueDate(taskdto.getDueDate());
        task.setDescription(taskdto.getDescription());
        List<SubTask> subtasks = new ArrayList<>();
        for (SubTaskdto t: taskdto.getSubTasks()) {
            SubTask subtask = new SubTask();
            subtask.setDescription(t.getDescription());
            subtask.setTitel(t.getTitel());
            subtasks.add(subtask);
        }
        task.setSubTasks(subtasks);
        return task;
    }
}
