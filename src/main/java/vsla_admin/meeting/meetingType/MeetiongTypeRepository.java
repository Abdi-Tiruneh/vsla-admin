package vsla_admin.meeting.meetingType;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import vsla_admin.organization.organization.Organization;

public interface MeetiongTypeRepository extends JpaRepository<MeetingType,Long> {
     MeetingType findMeetingTypeByMeetingTypeId(Long meetingTypeId);
     List<MeetingType> findMeetingTypeByOrganization(Organization organization);
}
