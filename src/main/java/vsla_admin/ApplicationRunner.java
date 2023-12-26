package vsla_admin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import vsla_admin.userManager.role.Role;
import vsla_admin.userManager.role.RoleRepository;
import vsla_admin.userManager.user.UserRepository;
import vsla_admin.userManager.user.Users;
import vsla_admin.utils.Status;

import java.util.List;

@Configuration
@ConditionalOnProperty(prefix = "database", name = "seed", havingValue = "true")
@RequiredArgsConstructor
@Slf4j
public class ApplicationRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    /**
     * Initializes the database with preloaded data upon application startup.
     */
    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            try {
                // Create and save roles
                List<Role> roles = createUserRole();
                roles = roleRepository.saveAll(roles);

                // Create and save user
                Users johnDoe = createUser(roles.get(0));
                userRepository.save(johnDoe);

                log.info("ApplicationRunner => Preloaded roles and admin user");
            } catch (Exception ex) {
                log.error("ApplicationRunner Preloading Error: {}", ex.getMessage());
                throw new RuntimeException("ApplicationRunner Preloading Error ", ex);
            }
        };
    }


    //TODO: Update role descriptions
    private List<Role> createUserRole() {
        Role superAdmin = new Role("SUPER_ADMIN", "Manages organization and organization admins");
        Role admin = new Role("ORGANIZATION_ADMIN", "Manages all aspects of the application.");

        return List.of(superAdmin, admin);
    }

    private Users createUser(Role role) {
        return Users.builder()
                .username("john")
                .password(passwordEncoder.encode("123456"))
                .fullName("John Doe")
                .email("john@gmail.com")
                .phoneNumber("0912345678")
                .role(role)
                .userStatus(Status.ACTIVE)
                .build();
    }
}