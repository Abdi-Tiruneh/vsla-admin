package vsla_admin.groupSetting;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vsla_admin.organization.organization.Organization;

public interface GroupSettingRepository extends JpaRepository<GroupSetting,Long>{

    GroupSetting findGroupSettingByGroupSettingId(Long groupSettingId);
    List<GroupSetting> findGroupSettingByOrganization(Organization organization);
    
}

