package vsla_admin.meeting.meetingInterval;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vsla_admin.exceptions.customExceptions.UnauthorizedException;
import vsla_admin.organization.organization.Organization;
import vsla_admin.organization.organization.OrganizationRepository;
import vsla_admin.userManager.user.Users;
import vsla_admin.utils.CurrentlyLoggedInUser;

@RequiredArgsConstructor
@Service
public class MeetingIntervalServiceImpl implements MeetingIntervalService {
     @Autowired
    private final MeetingIntervalRepository meetingIntervalRepository;
    private final CurrentlyLoggedInUser currentlyLoggedInUser; 
    private final OrganizationRepository organizationRepository; 

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
    public List<MeetingInterval> getMeetingIntervalByOrganization() {
        Users loggedInUser = currentlyLoggedInUser.getUser();
        return meetingIntervalRepository.findMeetingIntervalByOrganizationAndIsActive(loggedInUser.getOrganization(),true);
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

    @Override
    public MeetingInterval deleteMeetingInterval(Long meetingIntervalId) {
        MeetingInterval meetingInterval= meetingIntervalRepository.findMeetingIntervalByMeetingIntervalId(meetingIntervalId);
        meetingInterval.setIsActive(false);
        return meetingIntervalRepository.save(meetingInterval);
    }

    @Override
    public List<MeetingInterval> getMeetingIntervalForApp(Long organizationId) {
        Organization organization=organizationRepository.findByOrganizationId(organizationId);
       return meetingIntervalRepository.findMeetingIntervalByOrganizationAndIsActive(organization, true);
    }
    
}
