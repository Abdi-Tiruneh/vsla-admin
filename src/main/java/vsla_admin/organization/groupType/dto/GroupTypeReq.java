package vsla_admin.organization.groupType.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class GroupTypeReq {

    @NotBlank(message = "Group Type Name is required")
    private String groupTypeName;
}