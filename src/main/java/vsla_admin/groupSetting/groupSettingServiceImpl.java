package vsla_admin.groupSetting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class GroupSettingServiceImpl implements GroupSettingService{
    @Autowired
    private final GroupSettingRepository groupSettingRepositories;

    @Override
    public GroupSetting addGroupSetting(GroupSetting groupSettings) {
      return groupSettingRepositories.save(groupSettings);
    }

    @Override
    public GroupSetting editgrGroupSetting(GroupSetting groupSettings) {
      return groupSettingRepositories.save(groupSettings);
    }

    @Override
    public List<GroupSetting> getGroupSetting() {
        return groupSettingRepositories.findAll();
    }


    @Override
    public GroupSetting getGroupSettingByGroupSettingId(Long groupSettingId) {
      return groupSettingRepositories.findGroupSettingByGroupSettingId(groupSettingId);
    }
    
    
}
