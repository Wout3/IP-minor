package r0661554.project.taskmanager.dto;

import javax.validation.constraints.NotEmpty;

public class SubTaskdto {

    private Long id;
    @NotEmpty
    private String description;
    @NotEmpty
    private String Titel;

    public SubTaskdto(Long id, @NotEmpty String description, @NotEmpty String titel) {
        this.id = id;
        this.description = description;
        Titel = titel;
    }

    public SubTaskdto() {
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
