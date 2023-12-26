package vsla_admin.meeting.meetingInterval;

import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "MeetingInterval", url = "${VSLA_APP.BASE_URL}" + "meeting-intervals")
public interface MeetingIntervalFeignClient {
    @GetMapping
    ResponseEntity<?> getAllMeetingIntervals();

    @PostMapping
    ResponseEntity<?> createMeetingInterval(@RequestBody @Valid MeetingIntervalReq meetingIntervalReq);

    @PutMapping("/{meetingId}")
    ResponseEntity<?> updateMeetingInterval(@PathVariable Long meetingId, @RequestBody MeetingIntervalReq meetingIntervalReq);
}
