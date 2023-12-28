package vsla_admin.groupSetting;

import java.util.List;


public interface groupSettingService {

    groupSetting addGroupSetting (groupSetting groupSettings);
    groupSetting editgrGroupSetting (groupSetting groupSettings);
    List<groupSetting> getGroupSetting();
    groupSetting getGroupSettingByGroupSettingId(Long groupSettingId);
}
