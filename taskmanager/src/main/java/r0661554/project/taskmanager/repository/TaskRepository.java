package r0661554.project.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import r0661554.project.taskmanager.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}