package vsla_admin.organization.organization.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import vsla_admin.address.dto.AddressReq;

@Data
public class OrganizationRegistration {

    @NotBlank(message = "Project Name is required")
    private String organizationName;

    @NotNull(message = "Address is required")
    private AddressReq address;

}