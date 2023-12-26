package vsla_admin.organization.project.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProjectReq {

    @NotBlank(message = "Project Name is required")
    private String projectName;
}