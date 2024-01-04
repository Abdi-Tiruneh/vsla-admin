package vsla_admin.meeting.meetings;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Meetings", url = "${VSLA_APP.BASE_URL}" + "meetings")
public interface MeetingsFeignClient {
    @GetMapping("/getAllMeetings/Admin/{organizationId}")
    ResponseEntity<?> getAllMeetings(@PathVariable Long organizationId);
} 
