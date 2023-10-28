package vsla_admin.userManager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import vsla_admin.utils.Status;

import java.time.LocalDateTime;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {

    private Long userId;

    private String username;

    private String fullName;

    private String email;
    private String phoneNumber;
    private String role;

    private Status status;

    private LocalDateTime lastLoggedIn;

    private LocalDateTime registeredAt;

    private String registeredBy;

    private LocalDateTime updatedAt;

}
