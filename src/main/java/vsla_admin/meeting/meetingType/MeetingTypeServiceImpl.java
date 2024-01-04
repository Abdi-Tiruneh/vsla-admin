package vsla_admin.meeting.meetingType;

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
public class MeetingTypeServiceImpl implements MeetingTypeService {
    @Autowired
    private final MeetiongTypeRepository meetiongTypeRepository;
    private final CurrentlyLoggedInUser currentlyLoggedInUser;  
    private final OrganizationRepository organizationRepository;
    @Override
    public MeetingType editMeetingType(MeetingType meetingType) {
       Users loggedInUser = currentlyLoggedInUser.getUser();
      if(loggedInUser.getOrganization().getOrganizationId().compareTo(meetingType.getOrganization().getOrganizationId())!=0)
      {
        throw new UnauthorizedException("user is not authorized");
      }
      else{
          return meetiongTypeRepository.save(meetingType);
      }
    }

    @Override
    public List<MeetingType> getMeetingType() {
       Users loggedInUser = currentlyLoggedInUser.getUser();
       return meetiongTypeRepository.findMeetingTypeByOrganizationAndIsActive(loggedInUser.getOrganization(),true);
    }

    @Override
    public MeetingType getMeetingTypeByMeetingTypeId(Long meetingTypeId) {
        return meetiongTypeRepository.findMeetingTypeByMeetingTypeId(meetingTypeId);
    }

    @Override
    public MeetingType addMeetingType(MeetingType meetingType) {
        Users loggedInUser = currentlyLoggedInUser.getUser();
        meetingType.setOrganization(loggedInUser.getOrganization());
        return meetiongTypeRepository.save(meetingType);
    }

    @Override
    public MeetingType deleteMeetingType(Long meetingTypeId) {
       MeetingType meetingType=meetiongTypeRepository.findMeetingTypeByMeetingTypeId(meetingTypeId);
       meetingType.setIsActive(false);
       return meetiongTypeRepository.save(meetingType);
    }

    @Override
    public List<MeetingType> getMeetingTypeForApp(Long organizationId) {
        Organization organization=organizationRepository.findByOrganizationId(organizationId);
        System.out.println(organization.getOrganizationName());
       return meetiongTypeRepository.findMeetingTypeByOrganizationAndIsActive(organization,true);
    }
    
}
