package vsla_admin.meeting.meetings;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import vsla_admin.userManager.user.Users;
import vsla_admin.utils.CurrentlyLoggedInUser;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/meetings")
@Tag(name = "Meetings-Api")
public class MeetingsController {
    private final MeetingsFeignClient meetingsFeignClient;
    private final CurrentlyLoggedInUser currentlyLoggedInUser;
    @GetMapping("/getAllMeetings")
    public ResponseEntity<?> getAllMeetingIntervals() {
        Users loggedInUser = currentlyLoggedInUser.getUser();
        return meetingsFeignClient.getAllMeetings(loggedInUser.getOrganization().getOrganizationId());
    }
}
