package vsla_admin.userManager.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vsla_admin.exceptions.customExceptions.ResourceNotFoundException;
import vsla_admin.userManager.dto.UserRegistrationReq;
import vsla_admin.userManager.role.Role;
import vsla_admin.utils.Status;

@Service
@RequiredArgsConstructor
public class UserUtils {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Users createUser(UserRegistrationReq userReq, Users loggedInUser, Role role) {
        return Users.builder()
                .username(userReq.getUsername())
                .password(passwordEncoder.encode(userReq.getPassword()))
                .fullName(userReq.getFullName())
                .email(userReq.getEmail())
                .phoneNumber(userReq.getPhoneNumber())
                .role(role)
                .userStatus(Status.ACTIVE)
                .build();
    }

    public boolean isEmailTaken(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public boolean isUsernameTaken(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    public boolean isPhoneNumberTaken(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber).isPresent();
    }

    public Users getById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

}
