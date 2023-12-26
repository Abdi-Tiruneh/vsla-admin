package vsla_admin.meeting.meetingType;

import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "MeetingType", url = "${VSLA_APP.BASE_URL}" + "meeting-types")
public interface MeetingTypeFeignClient {
    @GetMapping
    ResponseEntity<?> getAllMeetingTypes();

    @PostMapping
    ResponseEntity<?> createMeetingType(@RequestBody @Valid MeetingTypeReq meetingTypeReq);

    @PutMapping("/{meetingTypeId}")
    ResponseEntity<?> updateMeetingType(@PathVariable Long meetingTypeId, @RequestBody MeetingTypeReq meetingTypeReq);
}
