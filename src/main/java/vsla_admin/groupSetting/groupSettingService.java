package vsla_admin.groupSetting;

import java.util.List;

public interface GroupSettingService {

    GroupSetting addGroupSetting (GroupSetting groupSettings);

    GroupSetting editgrGroupSetting (GroupSetting groupSettings);

    List<GroupSetting> getGroupSetting();
    
    GroupSetting getGroupSettingByGroupSettingId(Long groupSettingId);
}
