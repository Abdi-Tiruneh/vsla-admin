package vsla_admin.mileStoneSetting;

import java.util.List;

public interface mileStoneSettingService {
    
    mileStoneSetting editMileStoneSetting( mileStoneSetting     mileStoneSettings);
    List<mileStoneSetting> getMileStoneSetting();
    mileStoneSetting getMileStoneSettingByMileStoneSettingId(Long mileStoneSettingId);

}


