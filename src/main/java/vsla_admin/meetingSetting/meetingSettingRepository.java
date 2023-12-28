package vsla_admin.meetingSetting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface meetingSettingRepository extends JpaRepository<meetingSetting, Long> {
    

        meetingSetting findMeetingSettingByMeetingSettingId(Long meetingSettingId);
}
