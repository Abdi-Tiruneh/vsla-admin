package vsla_admin.groupSetting;

import org.springframework.data.jpa.repository.JpaRepository;


public interface groupSettingRepository extends JpaRepository<groupSetting,Long>{

    groupSetting findGroupSettingByGroupSettingId(Long groupSettingId);
    
}
