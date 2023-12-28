package vsla_admin.groupSetting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class groupSettingServiceImpl implements groupSettingService{
    @Autowired
    private final groupSettingRepository groupSettingRepositories;

    @Override
    public groupSetting addGroupSetting(groupSetting groupSettings) {
      return groupSettingRepositories.save(groupSettings);
    }

    @Override
    public groupSetting editgrGroupSetting(groupSetting groupSettings) {
      return groupSettingRepositories.save(groupSettings);
    }

    @Override
    public List<groupSetting> getGroupSetting() {
        return groupSettingRepositories.findAll();
    }


    @Override
    public groupSetting getGroupSettingByGroupSettingId(Long groupSettingId) {
      return groupSettingRepositories.findGroupSettingByGroupSettingId(groupSettingId);
    }
    
    
}
