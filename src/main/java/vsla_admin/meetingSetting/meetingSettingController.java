package vsla_admin.meetingSetting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/meetingSetting")

public class meetingSettingController {
    
    @Autowired
    private final meetingSettingService meetingSettingServices;

     @PostMapping("/add")
    public ResponseEntity<createResponse> addMeetingSetting (@RequestBody meetingSetting meetingSettings) {
        meetingSettingServices.addMeetingSetting(meetingSettings);
        createResponse response = new createResponse("success", "meetingSetting created sucessfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getmeetingSetting")
    List<meetingSetting> meetingSetting() {
        return this.meetingSettingServices.getmeetingSetting();
    }

    @GetMapping("/{meetingSettingId}")
    meetingSetting getMeetingSetting(@PathVariable Long meetingSettingId){
    return meetingSettingServices.getMeetingSettingByMeetingSettingId(meetingSettingId);
    }
    
    @PutMapping("/edit/{meetingSettingId}")
    
    meetingSetting editMeetingSetting(@RequestBody meetingSetting tempMeetingSetting, @PathVariable Long meetingSettingId) {
        meetingSetting meetingSettings = this.meetingSettingServices.getMeetingSettingByMeetingSettingId(meetingSettingId);
        meetingSettings.setMinTime(tempMeetingSetting.getMinTime());
        meetingSettings.setMaxTime(tempMeetingSetting.getMaxTime());
        meetingSettings.setMeetingInterval(tempMeetingSetting.getMeetingInterval());
        meetingSettings.setStatus(tempMeetingSetting.getStatus());
        return meetingSettingServices.editMeetingSetting(meetingSettings);

    }





   
}
