package vsla_admin.meetingSetting;

import java.util.List;

public interface meetingSettingService {

    meetingSetting addMeetingSetting (meetingSetting meetingSettings);
    meetingSetting editMeetingSetting(meetingSetting meetingSettings);
    List<meetingSetting> getmeetingSetting();
    meetingSetting getMeetingSettingByMeetingSettingId(Long meetingSettingId);


    
}

