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

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import vsla_admin.Response.createResponse;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/groupSetting")

public class groupSettingController {

    @Autowired 
    private final groupSettingService groupSettingServices;
     
    @PostMapping("/add")
    public ResponseEntity<createResponse> addGroupSetting (@RequestBody groupSetting groupSettings) {
        groupSettingServices.addGroupSetting(groupSettings);
        createResponse response = new createResponse("success", "groupSetting created sucessfully");
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/getGroupSetting")
    List<groupSetting> getGroupSetting() {
        return this.groupSettingServices.getGroupSetting();
    }

    @GetMapping("/{groupSettingId}")
    groupSetting getGroupSetting(@PathVariable Long groupSettingId) {
        return groupSettingServices.getGroupSettingByGroupSettingId(groupSettingId);
    }
   

   @PutMapping("/edit/{groupSettingId}")
    groupSetting editGroupSetting(@RequestBody groupSetting tempGroupSetting, @PathVariable Long groupSettingId) {
        groupSetting groupsettings = this.groupSettingServices.getGroupSettingByGroupSettingId(groupSettingId);
        groupsettings.setMaxGroupMember(tempGroupSetting.getMaxGroupMember());
        groupsettings.setMaxPayableAmount(tempGroupSetting.getMaxPayableAmount());
        groupsettings.setMinGroupMember(tempGroupSetting.getMinGroupMember());
        groupsettings.setMinPayableAmount(tempGroupSetting.getMinPayableAmount());
        groupsettings.setStatus(tempGroupSetting.getStatus());
        return groupSettingServices.editgrGroupSetting(groupsettings);
    }
      


    
}
