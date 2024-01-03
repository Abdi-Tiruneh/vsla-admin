package vsla_admin.meeting.meetingType;

import java.util.List;

public interface MeetingTypeService {
    MeetingType editMeetingType( MeetingType meetingType);
    List<MeetingType> getMeetingType();
    MeetingType getMeetingTypeByMeetingTypeId(Long meetingTypeId);
    MeetingType addMeetingType( MeetingType meetingType );   
} 