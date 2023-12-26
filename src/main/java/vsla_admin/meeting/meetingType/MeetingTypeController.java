package vsla_admin.meeting.meetingType;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/meeting-types")
@Tag(name = "Meeting Type API.")
public class MeetingTypeController {
    private final MeetingTypeFeignClient meetingTypeFeignClient;

    public MeetingTypeController(MeetingTypeFeignClient meetingTypeFeignClient) {
        this.meetingTypeFeignClient = meetingTypeFeignClient;
    }

    @GetMapping
    public ResponseEntity<?> getAllMeetingTypes() {
        return meetingTypeFeignClient.getAllMeetingTypes();
    }

    @PostMapping
    public ResponseEntity<?> createMeetingType(@RequestBody @Valid MeetingTypeReq meetingTypeReq) {
        return meetingTypeFeignClient.createMeetingType(meetingTypeReq);
    }

    @PutMapping("/{meetingTypeId}")
    public ResponseEntity<?> updateMeetingType(@PathVariable Long meetingTypeId, @RequestBody MeetingTypeReq meetingTypeReq) {
        return meetingTypeFeignClient.updateMeetingType(meetingTypeId, meetingTypeReq);
    }
}


