package vsla_admin.meeting.meetingInterval;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/meeting-intervals")
@Tag(name = "Meeting Interval API.")
public class MeetingIntervalController {
    private final MeetingIntervalFeignClient meetingIntervalFeignClient;

    public MeetingIntervalController(MeetingIntervalFeignClient meetingIntervalFeignClient) {
        this.meetingIntervalFeignClient = meetingIntervalFeignClient;
    }


    @GetMapping
    public ResponseEntity<?> getAllMeetingIntervals() {
        return meetingIntervalFeignClient.getAllMeetingIntervals();
    }

    @PostMapping
    public ResponseEntity<?> createMeetingInterval(@RequestBody @Valid MeetingIntervalReq meetingIntervalReq) {
        return meetingIntervalFeignClient.createMeetingInterval(meetingIntervalReq);
    }

    @PutMapping("/{meetingId}")
    public ResponseEntity<?> updateMeetingInterval(@PathVariable Long meetingId, @RequestBody MeetingIntervalReq meetingIntervalReq) {
        return meetingIntervalFeignClient.updateMeetingInterval(meetingId, meetingIntervalReq);
    }
}


