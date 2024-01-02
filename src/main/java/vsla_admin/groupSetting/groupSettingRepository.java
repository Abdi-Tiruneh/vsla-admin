package vsla_admin.groupSetting;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupSettingRepository extends JpaRepository<GroupSetting,Long>{

    GroupSetting findGroupSettingByGroupSettingId(Long groupSettingId);
    
}

