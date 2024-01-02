package vsla_admin.organization.project.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProjectReq {

    @NotBlank(message = "Project Name is required")
    private String projectName;
    @NotBlank(message = "Project description is required")
    private String description;
    @NotBlank(message = "Project area is required")
    private String area;
    
}