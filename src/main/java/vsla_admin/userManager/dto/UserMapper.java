package vsla_admin.userManager.dto;

import vsla_admin.userManager.user.Users;

public class UserMapper {
    public static UserResponse toUserResponse(Users user) {
        return UserResponse.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .role(user.getRole().getRoleName())
                .status(user.getUserStatus())
                .lastLoggedIn(user.getLastLoggedIn())
                .registeredAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}

