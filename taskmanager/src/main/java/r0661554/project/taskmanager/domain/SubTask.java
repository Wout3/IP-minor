package r0661554.project.taskmanager.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity
public class SubTask {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String description;
    @NotEmpty
    private String Titel;


    public SubTask(String description, String titel) {
        this.description = description;
        Titel = titel;
    }

    public SubTask() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
