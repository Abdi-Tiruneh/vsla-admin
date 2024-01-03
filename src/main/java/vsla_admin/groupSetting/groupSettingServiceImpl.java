package vsla_admin.groupSetting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vsla_admin.exceptions.customExceptions.UnauthorizedException;
import vsla_admin.userManager.user.Users;
import vsla_admin.utils.CurrentlyLoggedInUser;

@Service
@RequiredArgsConstructor

public class GroupSettingServiceImpl implements GroupSettingService{
    @Autowired
    private final GroupSettingRepository groupSettingRepositories;
    private final CurrentlyLoggedInUser currentlyLoggedInUser;

    @Override
    public GroupSetting addGroupSetting(GroupSetting groupSettings) {
      return groupSettingRepositories.save(groupSettings);
    }

    @Override
    public GroupSetting editgrGroupSetting(GroupSetting groupSettings) {
      Users loggedInUser = currentlyLoggedInUser.getUser();
      if(loggedInUser.getOrganization().getOrganizationId().compareTo(groupSettings.getOrganization().getOrganizationId())!=0)
      {
        throw new UnauthorizedException("user is not authorized");
      }
      else{
           return groupSettingRepositories.save(groupSettings);
      }
   
    }

    @Override
    public List<GroupSetting> getGroupSetting() {
       Users loggedInUser = currentlyLoggedInUser.getUser();
        return groupSettingRepositories.findGroupSettingByOrganizationAndIsActive(loggedInUser.getOrganization(), true);
    }


    @Override
    public GroupSetting getGroupSettingByGroupSettingId(Long groupSettingId) {
      return groupSettingRepositories.findGroupSettingByGroupSettingId(groupSettingId);
    }
    
    
}
