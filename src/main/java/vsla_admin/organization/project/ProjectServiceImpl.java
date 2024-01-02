package vsla_admin.organization.project;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vsla_admin.exceptions.customExceptions.ResourceNotFoundException;
import vsla_admin.organization.project.dto.ProjectReq;
import vsla_admin.userManager.user.Users;
import vsla_admin.utils.CurrentlyLoggedInUser;
import vsla_admin.utils.Status;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final CurrentlyLoggedInUser currentlyLoggedInUser;

    @Override
    public Project createProject(ProjectReq projectReq) {
        Users loggedInUser = currentlyLoggedInUser.getUser();

        // Create a new Project
        Project project = new Project();
        project.setProjectName(projectReq.getProjectName());
        project.setStatus(Status.ACTIVE);
        project.setOrganization(loggedInUser.getOrganization());
        project.setDescription(projectReq.getDescription());
        project.setArea(projectReq.getArea());

        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(Long groupTypeId, ProjectReq projectReq) {
        Project project = getById(groupTypeId);

        if (projectReq.getProjectName() != null)
            project.setProjectName(projectReq.getProjectName());
            project.setDescription(projectReq.getDescription());
            project.setArea(projectReq.getArea());

        return projectRepository.save(project);
    }

    @Override
    public List<Project> getAllProjectsByOrganization(Long organizationId) {
        return projectRepository.findByOrganizationOrganizationId(organizationId);
    }

    @Override
    public void deleteProject(Long groupTypeId) {
        getById(groupTypeId);
        projectRepository.deleteById(groupTypeId);
    }

    private Project getById(Long groupTypeId) {
        return projectRepository.findById(groupTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with ID: " + groupTypeId));
    }

    @Override
    public List<Project> getAllProjectsByprojectId(Long projectId) {
       return projectRepository.findAll();
    }
}
