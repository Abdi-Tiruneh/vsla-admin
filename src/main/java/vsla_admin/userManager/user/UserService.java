package vsla_admin.userManager.user;

import vsla_admin.userManager.dto.UserRegistrationReq;
import vsla_admin.userManager.dto.UserResponse;
import vsla_admin.userManager.dto.UserUpdateReq;

import java.util.List;

public interface UserService {
    UserResponse register(UserRegistrationReq userReq);

    UserResponse editUser(UserUpdateReq updateReq);

    UserResponse me();

    List<UserResponse> getAllUsers();

    void deleteUser(Long userId);

}
