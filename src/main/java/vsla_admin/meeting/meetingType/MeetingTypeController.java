package vsla_admin.meeting.meetingType;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/meeting-types")
@Tag(name = "Meeting Type API.")
public class MeetingTypeController {
    //private final MeetingTypeFeignClient meetingTypeFeignClient;

    // public MeetingTypeController(MeetingTypeFeignClient meetingTypeFeignClient) {
    //     this.meetingTypeFeignClient = meetingTypeFeignClient;
    // }

    // @GetMapping
    // public ResponseEntity<?> getAllMeetingTypes() {
    //     return meetingTypeFeignClient.getAllMeetingTypes();
    // }

    // @PostMapping
    // public ResponseEntity<?> createMeetingType(@RequestBody @Valid MeetingTypeReq meetingTypeReq) {
    //     return meetingTypeFeignClient.createMeetingType(meetingTypeReq);
    // }

    // @PutMapping("/{meetingTypeId}")
    // public ResponseEntity<?> updateMeetingType(@PathVariable Long meetingTypeId, @RequestBody MeetingTypeReq meetingTypeReq) {
    //     return meetingTypeFeignClient.updateMeetingType(meetingTypeId, meetingTypeReq);
    // }
    @Autowired
    private final MeetingTypeService meetingTypeService;
    @GetMapping("/getAll")
    List<MeetingType> get() {
        return meetingTypeService.getMeetingType();
    }
    @GetMapping("/getAll/App")
    List<MeetingType> getForApp() {
        return meetingTypeService.getMeetingTypeForApp();
    }
     @GetMapping("getById/{meetingTypeId}")
    MeetingType getMeetingType(@PathVariable Long meetingTypeId) {
        return meetingTypeService.getMeetingTypeByMeetingTypeId(meetingTypeId);
    }
    @PutMapping("/edit/{meetingTypeId}")
    MeetingType editMeetingType(@RequestBody MeetingType tempMeetingType, @PathVariable Long meetingTypeId) {
        MeetingType meetingType = this.meetingTypeService.getMeetingTypeByMeetingTypeId(meetingTypeId);
        meetingType.setMeetingTypeName(tempMeetingType.getMeetingTypeName());
        meetingType.setIsActive(tempMeetingType.getIsActive());
        return meetingTypeService.editMeetingType(meetingType);
    }
     @PostMapping("/add")
     MeetingType addMeetingType(@RequestBody MeetingType meetingType) {
        return meetingTypeService.addMeetingType(meetingType);
    }
     @DeleteMapping("/delete/{meetingTypeId}")
    MeetingType deleteMeetingType(@PathVariable Long meetingTypeId) {
        return meetingTypeService.deleteMeetingType(meetingTypeId);
    }
}


