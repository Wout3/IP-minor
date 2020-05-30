package r0661554.project.taskmanager.dto;

import r0661554.project.taskmanager.domain.Task;

import java.time.LocalDateTime;
import java.util.*;

public class Taskdto {
    private Long id;
    private String description;
    private LocalDateTime dueDate;
    private String Titel;
    private List<SubTaskdto> subtasks = new ArrayList<>();

    public Taskdto(Long id, String description, LocalDateTime dueDate, String titel) {
        this.id = id;
        this.description = description;
        this.dueDate = dueDate;
        this.Titel = titel;
    }

    public Taskdto(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void addTask(SubTaskdto task){
        subtasks.add(task);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public String getTitel() {
        return Titel;
    }

    public void setTitel(String titel) {
        Titel = titel;
    }

    public List<SubTaskdto> getSubTasks(){
        return subtasks;
    }

    public void setSubTasksdto(List<SubTaskdto> subtasks){
        this.subtasks = subtasks;
    }
}
