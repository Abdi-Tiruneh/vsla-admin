package vsla_admin.mileStoneSetting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class mileStoneSettingServiceImpl implements mileStoneSettingService{

    @Autowired
    private final mileStoneSettingRepository mileStoneSettingRepositories;
    @Override
    public mileStoneSetting editMileStoneSetting(mileStoneSetting MileStoneSetting) {
       return mileStoneSettingRepositories.save(MileStoneSetting);
    }

    @Override
    public List<mileStoneSetting> getMileStoneSetting() {
       return mileStoneSettingRepositories.findAll();
    }

    @Override
    public mileStoneSetting getMileStoneSettingByMileStoneSettingId(Long mileStoneSettingId) {
       return mileStoneSettingRepositories.findMileStoneSettingByMileStoneSettingId(mileStoneSettingId);
    }
    
}
