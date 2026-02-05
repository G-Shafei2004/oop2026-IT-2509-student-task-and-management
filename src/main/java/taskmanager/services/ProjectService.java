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
        projectRepo.save(project);   // ✅ updated
    }

    public Project getProjectById(int id) {
        return projectRepo.findById(id);   // ✅ updated
    }

    public List<Project> getAllProjects() {
        return projectRepo.findAll();      // ✅ updated
    }

    public void deleteProject(int id) {
        projectRepo.delete(id);            // ✅ optional but consistent
    }
}
