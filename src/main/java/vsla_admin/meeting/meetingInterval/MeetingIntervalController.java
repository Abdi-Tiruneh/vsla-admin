package vsla_admin.meeting.meetingInterval;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/meeting-intervals")
@Tag(name = "Meeting Interval API.")
public class MeetingIntervalController {
    // private final MeetingIntervalFeignClient meetingIntervalFeignClient;

    // public MeetingIntervalController(MeetingIntervalFeignClient meetingIntervalFeignClient) {
    //     this.meetingIntervalFeignClient = meetingIntervalFeignClient;
    // }


    // @GetMapping
    // public ResponseEntity<?> getAllMeetingIntervals() {
    //     return meetingIntervalFeignClient.getAllMeetingIntervals();
    // }

    // @PostMapping
    // public ResponseEntity<?> createMeetingInterval(@RequestBody @Valid MeetingIntervalReq meetingIntervalReq) {
    //     return meetingIntervalFeignClient.createMeetingInterval(meetingIntervalReq);
    // }

    // @PutMapping("/{meetingId}")
    // public ResponseEntity<?> updateMeetingInterval(@PathVariable Long meetingId, @RequestBody MeetingIntervalReq meetingIntervalReq) {
    //     return meetingIntervalFeignClient.updateMeetingInterval(meetingId, meetingIntervalReq);
    // }
    @Autowired
    private final MeetingIntervalService meetingIntervalService;
    
    @GetMapping("/getAll")
    List<MeetingInterval> get() {
        return meetingIntervalService.getMeetingInterval();
    }
     @GetMapping("getById/{meetingIntervalId}")
    MeetingInterval getMeetingInterval(@PathVariable Long meetingIntervalId) {
        return meetingIntervalService.getmeetingIntervalByMeetingIntervaId(meetingIntervalId);
    }
    @PutMapping("/edit/{meetingIntervalId}")
    MeetingInterval editMeetingInterval(@RequestBody MeetingInterval tempMeetingInterval, @PathVariable Long meetingIntervalId) {
        MeetingInterval meetingInterval = this.meetingIntervalService.getmeetingIntervalByMeetingIntervaId(meetingIntervalId);
        meetingInterval.setMeetingIntervalName(tempMeetingInterval.getMeetingIntervalName());
        meetingInterval.setIntervalInDays(tempMeetingInterval.getIntervalInDays());
        meetingInterval.setIsActive(tempMeetingInterval.getIsActive());
        return meetingIntervalService.editMeetingInterval(meetingInterval);
    }
     @PostMapping("/add")
     MeetingInterval addMeetingInterval(@RequestBody MeetingInterval meetingInterval) {
        return meetingIntervalService.addmeetingInterval(meetingInterval);
    }
    
}


