package vsla_admin.company.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;
import vsla_admin.address.Address;
import vsla_admin.userManager.dto.UserResponse;
import vsla_admin.utils.Status;

import java.time.LocalDateTime;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyResponse {
    private Long companyId;

    private String companyName;

    private boolean enabled;

    @Enumerated(EnumType.STRING)
    private Status companyStatus;

    private Address address;

    private UserResponse registeredBy;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
