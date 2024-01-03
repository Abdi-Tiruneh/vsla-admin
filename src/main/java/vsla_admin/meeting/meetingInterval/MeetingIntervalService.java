package vsla_admin.meeting.meetingInterval;

import java.util.List;


public interface MeetingIntervalService {
    MeetingInterval editMeetingInterval( MeetingInterval meetingInterval);
    List<MeetingInterval> getMeetingInterval();
    MeetingInterval getmeetingIntervalByMeetingIntervaId(Long meetingIntervalId);
    MeetingInterval addmeetingInterval( MeetingInterval meetingInterval);
}
