package taskmanager.repositories;

import taskmanager.entities.Project;
import java.util.List;

public interface ProjectRepository {
    void createProject(Project project);
    Project findProjectById(int id);
    List<Project> listAllProjects();
}
