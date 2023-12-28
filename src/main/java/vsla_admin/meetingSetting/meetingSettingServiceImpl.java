package vsla_admin.meetingSetting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class meetingSettingServiceImpl implements meetingSettingService {
    
    @Autowired
    private final meetingSettingRepository meetingSettingRepositories;

    @Override
    public meetingSetting addMeetingSetting(meetingSetting meetingSettings) {
       return meetingSettingRepositories.save(meetingSettings);
    }

    @Override
    public meetingSetting editMeetingSetting(meetingSetting meetingSettings) {
       return meetingSettingRepositories.save(meetingSettings);
    }

    @Override
    public List<meetingSetting> getmeetingSetting() {
       return meetingSettingRepositories.findAll();
    }

    @Override
    public meetingSetting getMeetingSettingByMeetingSettingId(Long meetingSettingId) {
       return meetingSettingRepositories.findMeetingSettingByMeetingSettingId(meetingSettingId);
    }
    
}
