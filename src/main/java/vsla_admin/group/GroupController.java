package vsla_admin.group;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/groups")
@Tag(name = "Group API.")
public class GroupController {

    private final GroupFeignClient groupFeignClient;

    public GroupController(GroupFeignClient groupFeignClient) {
        this.groupFeignClient = groupFeignClient;
    }

    @GetMapping("/by-organization/{organizationId}")
    public ResponseEntity<?> getAllGroupsByOrganization(@PathVariable Long organizationId) {
        return groupFeignClient.getAllGroups(organizationId);
    }

    @GetMapping("/by-project/{projectId}")
    public ResponseEntity<?> getAllGroupsByProject(@PathVariable Long projectId) {
        return groupFeignClient.getAllGroupsByProject(projectId);
    }

    @GetMapping("/{groupId}/members")
    public ResponseEntity<?> getAllGroupMembers(@PathVariable Long groupId) {
        return groupFeignClient.getAllGroupMembers(groupId);
    }
}


