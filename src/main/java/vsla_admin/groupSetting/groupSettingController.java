package vsla_admin.groupSetting;


import org.springframework.http.HttpStatus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;
import vsla_admin.Response.createResponse;
import vsla_admin.userManager.user.Users;
import vsla_admin.utils.CurrentlyLoggedInUser;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/groupSetting")

public class GroupSettingController {

    @Autowired 
    private final GroupSettingService groupSettingServices;
    private final CurrentlyLoggedInUser currentlyLoggedInUser;
     
    @PostMapping("/add")
    public ResponseEntity<createResponse> addGroupSetting (@RequestBody GroupSetting groupSettings) {
         Users loggedInUser = currentlyLoggedInUser.getUser();
         groupSettings.setOrganization(loggedInUser.getOrganization());
        groupSettingServices.addGroupSetting(groupSettings);
        createResponse response = new createResponse("success", "groupSetting created sucessfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getGroupSetting")
    List<GroupSetting> getGroupSetting() {
        return this.groupSettingServices.getGroupSetting();
    }

    @GetMapping("/{groupSettingId}")
    GroupSetting getGroupSetting(@PathVariable Long groupSettingId) {
        return groupSettingServices.getGroupSettingByGroupSettingId(groupSettingId);
    }
   

   @PutMapping("/edit/{groupSettingId}")
    GroupSetting editGroupSetting(@RequestBody GroupSetting tempGroupSetting, @PathVariable Long groupSettingId) {
        GroupSetting groupsettings = this.groupSettingServices.getGroupSettingByGroupSettingId(groupSettingId);
         groupsettings.setMinGroupMember(tempGroupSetting.getMinGroupMember());
        groupsettings.setMaxGroupMember(tempGroupSetting.getMaxGroupMember());
        groupsettings.setMinPayableAmount(tempGroupSetting.getMinPayableAmount());
        groupsettings.setMaxPayableAmount(tempGroupSetting.getMaxPayableAmount());
        groupsettings.setStatus(tempGroupSetting.getStatus());
        return groupSettingServices.editgrGroupSetting(groupsettings);
    }
      


    
}
