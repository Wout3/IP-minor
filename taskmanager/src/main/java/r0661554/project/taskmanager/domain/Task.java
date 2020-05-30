package r0661554.project.taskmanager.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String description;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dueDate;
    @NotEmpty
    private String Titel;
    @OneToMany(cascade = CascadeType.ALL,fetch= FetchType.EAGER)
    private List<SubTask> subtasks = new ArrayList<>();



    public Task(LocalDateTime dueDate, String description, String Titel) {
        setDueDate(dueDate);
        setDescription(description);
        setTitel(Titel);
    }
    public Task() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitel() {
        return Titel;
    }

    public void setTitel(String titel) {
        Titel = titel;
    }

    public void addSubTask(SubTask subtask){
        subtasks.add(subtask);
        System.out.println("toegevoegd:  " + subtask.toString());
        System.out.println("toegevoegd:  " + subtasks.size());
    }

    public void setSubTasks(List<SubTask> subtasks){
        this.subtasks = subtasks;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public List<SubTask> getSubTasks(){
        return subtasks;
    }

}
