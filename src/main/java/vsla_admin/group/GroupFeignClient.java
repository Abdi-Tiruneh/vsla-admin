package vsla_admin.group;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Group", url = "${VSLA_APP.BASE_URL}" + "groups")
public interface GroupFeignClient {
    @GetMapping("/{groupId}/members")
    ResponseEntity<?> getAllGroupMembers(@PathVariable Long groupId);

    @GetMapping("/by-organization/{organizationId}")
    public ResponseEntity<?> getAllGroups(@PathVariable Long organizationId);

    @GetMapping("/by-project/{projectId}")
    ResponseEntity<?> getAllGroupsByProject(@PathVariable Long projectId);
}
