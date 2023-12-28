package vsla_admin.mileStoneSetting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/mileStoneSetting")
@RequiredArgsConstructor
public class mileStoneSettingController {
   
@Autowired
private final mileStoneSettingService mileStoneSettingServices;

@GetMapping("/getMileStoneSettings")
List<mileStoneSetting> getMileStoneSetting(){
    return this.mileStoneSettingServices.getMileStoneSetting();
}

@GetMapping("/{mileStoneSettingId}")
mileStoneSetting getMileStoneSetting(@PathVariable Long mileStoneSettingId){
    return mileStoneSettingServices.getMileStoneSettingByMileStoneSettingId(mileStoneSettingId);
}

   
@PutMapping("/edit/{mileStoneSettingId}")
mileStoneSetting editMileStoneSetting(@RequestBody mileStoneSetting tempMileStoneSetting, @PathVariable Long mileStoneSettingId){
    mileStoneSetting mileStoneSettings = this.mileStoneSettingServices.getMileStoneSettingByMileStoneSettingId(mileStoneSettingId);
    mileStoneSettings.setPackageName(tempMileStoneSetting.getPackageName());
    mileStoneSettings.setPackageStratValue(tempMileStoneSetting.getPackageStratValue());
    mileStoneSettings.setPackageEndValue(tempMileStoneSetting.getPackageEndValue());
    return mileStoneSettingServices.editMileStoneSetting(mileStoneSettings);


}






    



    
}
