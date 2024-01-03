package vsla_admin.awareness;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vsla_admin.awareness.dto.AwarenessReq;
import vsla_admin.utils.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/awareness")
@Tag(name = "Awareness API.")
public class AwarenessController {
    private final AwarenessService awarenessService;

    public AwarenessController(AwarenessService awarenessService) {
        this.awarenessService = awarenessService;
    }

    @PostMapping
    public List<Awareness> createAwareness(@ModelAttribute @Valid AwarenessReq awarenessReq) {
        List<Awareness> awareness = awarenessService.createAwareness(awarenessReq);
        return awareness;
    }

    @PutMapping("/{awarenessId}")
    public ResponseEntity<Awareness> updateAwareness(
            @PathVariable Long awarenessId, @ModelAttribute AwarenessReq awarenessReq) {
        return ResponseEntity.ok(awarenessService.updateAwareness(awarenessId, awarenessReq));
    }

    @GetMapping("/by-organization/{organizationId}")
    public ResponseEntity<List<Awareness>> getAllAwarenessByOrganization(@PathVariable Long organizationId) {
        return ResponseEntity.ok(awarenessService.getAllAwarenessByOrganization(organizationId));
    }

    @GetMapping
    public ResponseEntity<List<Awareness>> getAllAwarenessByOrganization() {
        return ResponseEntity.ok(awarenessService.getAllAwarenessByOrganization());
    }

    @GetMapping("/{awarenessId}")
    public ResponseEntity<Awareness> getAwarenessById(@PathVariable Long awarenessId) {
        return ResponseEntity.ok(awarenessService.getAwarenessById(awarenessId));
    }

    @DeleteMapping("/{awarenessId}")
    public ResponseEntity<ApiResponse> deleteAwareness(@PathVariable Long awarenessId) {
        awarenessService.deleteAwareness(awarenessId);
        return ApiResponse.success("Awareness deleted successfully");
    }
}