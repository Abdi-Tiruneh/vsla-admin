package vsla_admin.mileStoneSetting;

import org.springframework.data.jpa.repository.JpaRepository;

public interface mileStoneSettingRepository extends JpaRepository <mileStoneSetting, Long > {
    mileStoneSetting findMileStoneSettingByMileStoneSettingId(Long mileStoneSettingId);
    
}
