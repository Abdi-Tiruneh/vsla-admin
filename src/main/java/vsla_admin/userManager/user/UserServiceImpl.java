package vsla_admin.userManager.user;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vsla_admin.exceptions.customExceptions.ResourceAlreadyExistsException;
import vsla_admin.userManager.dto.UserMapper;
import vsla_admin.userManager.dto.UserRegistrationReq;
import vsla_admin.userManager.dto.UserResponse;
import vsla_admin.userManager.dto.UserUpdateReq;
import vsla_admin.userManager.role.Role;
import vsla_admin.userManager.role.RoleService;
import vsla_admin.utils.CurrentlyLoggedInUser;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserUtils userUtils;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final CurrentlyLoggedInUser currentlyLoggedInUser;

    @Override
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public UserResponse register(UserRegistrationReq userReq) {
        if (userUtils.isEmailTaken(userReq.getEmail()))
            throw new ResourceAlreadyExistsException("Email is already taken");

        if (userUtils.isUsernameTaken(userReq.getUsername()))
            throw new ResourceAlreadyExistsException("Username is already taken");

        if (userUtils.isPhoneNumberTaken(userReq.getPhoneNumber()))
            throw new ResourceAlreadyExistsException("Phone number is already taken");

        Role role = roleService.getRoleById(userReq.getRoleId());

        Users loggedInUser = currentlyLoggedInUser.getUser();
        Users user = userUtils.createUser(userReq, loggedInUser, role);
        Users savedUser = userRepository.save(user);
        return UserMapper.toUserResponse(savedUser);
    }

    @Override
    @Transactional
    public UserResponse editUser(UserUpdateReq updateReq) {
        Users user = currentlyLoggedInUser.getUser();

        if (updateReq.getFullName() != null)
            user.setFullName(updateReq.getFullName());

        // Update email if provided and different from the current email
        if (updateReq.getEmail() != null && !user.getEmail().equalsIgnoreCase(updateReq.getEmail())) {
            // Check if the new email is already taken
            if (userUtils.isEmailTaken(updateReq.getEmail()))
                throw new ResourceAlreadyExistsException("Email is already taken");

            user.setEmail(updateReq.getEmail());
        }

        // Update username if provided and different from the current username
        if (updateReq.getUsername() != null && !user.getUsername().equals(updateReq.getUsername())) {
            // Check if the new username is already taken
            if (userUtils.isUsernameTaken(updateReq.getUsername()))
                throw new ResourceAlreadyExistsException("Username is already taken");

            user.setUsername(updateReq.getUsername());
        }

        // Update phone number if provided and different from the current phone number
        if (updateReq.getPhoneNumber() != null && !user.getPhoneNumber().equals(updateReq.getPhoneNumber())) {
            // Check if the new Phone Number is already taken
            if (userUtils.isPhoneNumberTaken(updateReq.getPhoneNumber()))
                throw new ResourceAlreadyExistsException("Phone Number is already taken");

            user.setPhoneNumber(updateReq.getPhoneNumber());
        }

        user = userRepository.save(user);
        return UserMapper.toUserResponse(user);
    }

    @Override
    public UserResponse me() {
        Users user = currentlyLoggedInUser.getUser();
        return UserMapper.toUserResponse(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<Users> users = userRepository.findAll(Sort.by(Sort.Order.asc("userId")));
        return users.stream().map(UserMapper::toUserResponse).toList();
    }

    @Override
    public void deleteUser(Long userId) {

    }

}
