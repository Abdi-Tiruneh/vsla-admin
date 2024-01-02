package vsla_admin.organization.project;


import vsla_admin.organization.project.dto.ProjectReq;

import java.util.List;

public interface ProjectService {
    Project createProject(ProjectReq projectReq);

    Project updateProject(Long groupTypeId, ProjectReq projectReq);

    List<Project> getAllProjectsByOrganization(Long organizationId);
    List<Project> getAllProjectsByprojectId(Long projectId);

    void deleteProject(Long groupTypeId);
}
