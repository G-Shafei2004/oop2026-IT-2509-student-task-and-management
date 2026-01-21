
package taskmanager.services;

import taskmanager.entities.Project;
import taskmanager.repositories.ProjectRepository;
import java.util.List;

public class ProjectService {
    private final ProjectRepository projectRepo;

    public ProjectService(ProjectRepository projectRepo) {
        this.projectRepo = projectRepo;
    }

    public void createProject(Project project) {
        if (project.getTitle() == null || project.getTitle().isEmpty()) {
            throw new RuntimeException("Project title cannot be empty!");
        }
        projectRepo.createProject(project);
    }

    public Project getProjectById(int id) {
        return projectRepo.findProjectById(id);
    }

    public List<Project> getAllProjects() {
        return projectRepo.listAllProjects();
    }
}
