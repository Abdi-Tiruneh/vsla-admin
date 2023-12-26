package vsla_admin.organization.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;
import vsla_admin.address.Address;
import vsla_admin.organization.Organization;
import vsla_admin.userManager.dto.UserResponse;
import vsla_admin.userManager.user.Users;
import vsla_admin.utils.Status;

import java.time.LocalDateTime;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrganizationResponse {
    private Long organizationNameId;

    private String organizationNameName;

    private boolean enabled;

    @Enumerated(EnumType.STRING)
    private Status organizationNameStatus;

    private Address address;

    private UserResponse registeredBy;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static OrganizationResponse toResponse(Organization organization) {

        Users users = organization.getRegisteredBy();
        UserResponse registeredBy = UserResponse.builder()
                .userId(users.getUserId())
                .fullName(users.getFullName())
                .role(users.getRole().getRoleName())
                .build();

        return OrganizationResponse.builder()
                .organizationNameId(organization.getOrganizationId())
                .organizationNameName(organization.getOrganizationName())
                .enabled(organization.isEnabled())
                .organizationNameStatus(organization.getOrganizationStatus())
                .address(organization.getAddress())
                .registeredBy(registeredBy)
                .createdAt(organization.getCreatedAt())
                .updatedAt(organization.getUpdatedAt())
                .build();
    }

}
