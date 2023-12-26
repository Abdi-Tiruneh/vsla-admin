package vsla_admin.meeting.meetingType;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MeetingTypeReq {

    @NotBlank(message = "Meeting Type Name Name is required")
    private String meetingTypeName;

    private Boolean isActive;
}