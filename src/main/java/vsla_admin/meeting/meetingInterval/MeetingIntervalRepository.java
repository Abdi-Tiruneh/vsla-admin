package vsla_admin.meeting.meetingInterval;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import vsla_admin.organization.organization.Organization;

public interface MeetingIntervalRepository extends JpaRepository<MeetingInterval,Long>{
    MeetingInterval findMeetingIntervalByMeetingIntervalId(Long meetingIntervalId);
    List<MeetingInterval> findMeetingIntervalByOrganizationAndIsActive(Organization organization,Boolean isActive);
     List<MeetingInterval> findMeetingIntervalByIsActive(Boolean isActive);
}
