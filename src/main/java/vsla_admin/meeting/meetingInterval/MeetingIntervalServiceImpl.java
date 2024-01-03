package vsla_admin.meeting.meetingInterval;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vsla_admin.exceptions.customExceptions.UnauthorizedException;
import vsla_admin.userManager.user.Users;
import vsla_admin.utils.CurrentlyLoggedInUser;

@RequiredArgsConstructor
@Service
public class MeetingIntervalServiceImpl implements MeetingIntervalService {
     @Autowired
    private final MeetingIntervalRepository meetingIntervalRepository;
    private final CurrentlyLoggedInUser currentlyLoggedInUser;  

    @Override
    public MeetingInterval editMeetingInterval(MeetingInterval meetingInterval) {
        Users loggedInUser = currentlyLoggedInUser.getUser();
      if(loggedInUser.getOrganization().getOrganizationId().compareTo(meetingInterval.getOrganization().getOrganizationId())!=0)
      {
        throw new UnauthorizedException("user is not authorized");
      }
      else{
          return meetingIntervalRepository.save(meetingInterval);
      }
    }

    @Override
    public List<MeetingInterval> getMeetingInterval() {
        return meetingIntervalRepository.findAll();
    }

    @Override
    public MeetingInterval getmeetingIntervalByMeetingIntervaId(Long meetingIntervalId) {
        return meetingIntervalRepository.findMeetingIntervalByMeetingIntervalId(meetingIntervalId);
    }

    @Override
    public MeetingInterval addmeetingInterval(MeetingInterval meetingInterval) {
        Users loggedInUser = currentlyLoggedInUser.getUser();
        meetingInterval.setOrganization(loggedInUser.getOrganization());
        return meetingIntervalRepository.save(meetingInterval);
    }
    
}
