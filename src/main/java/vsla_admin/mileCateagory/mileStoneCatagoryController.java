package vsla_admin.mileCateagory;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import vsla_admin.groupSetting.GroupSetting;
import vsla_admin.userManager.user.Users;
import vsla_admin.utils.CurrentlyLoggedInUser;

@RestController
@RequestMapping("/api/v1/mileStoneCatagory")
@RequiredArgsConstructor

public class mileStoneCatagoryController {

    private final mileStoneCatagoryRepository mileStoneCatagoryRepositories;
    private final CurrentlyLoggedInUser currentlyLoggedInUser;
    private final mileStoneCatagoryService mileStoneCatagoryServices;

    // @GetMapping("/{mileStoneCatagoryId}")
    // public ResponseEntity<String> getmileStoneCatagoryById(@PathVariable Long
    // mileStoneCatagoryId) {
    // mileStoneCatagory mileStoneCatagorys =
    // mileStoneCatagoryRepositories.findMileStoneCatagoryByMileStoneCatagoryId(mileStoneCatagoryId);
    // if (mileStoneCatagorys != null) {
    // int value = mileStoneCatagorys.getValue();
    // String category = mileStoneCatagoryServices.getCatagory(value);
    // return ResponseEntity.ok(category);
    // } else {
    // return ResponseEntity.notFound().build();

    // }
    // }
    @GetMapping("/getMileStoneCategory")
         List<mileStoneCatagory> getMileStoneCatagory() {
      return this.mileStoneCatagoryServices.getMileStoneCatagory();
    }
   

    // @GetMapping
    // public ResponseEntity<List<mileStoneCatagory>> getUser(@PathVariable Long mileStoneCatagoryId) {
    //    List<mileStoneCatagory> mileStoneCatagorys = mileStoneCatagoryServices.getMileStoneCatagory();
    //    // .getMileStoneCatagory(mileStoneCatagoryId);
    //     if (mileStoneCatagorys == null) {
    //         return ResponseEntity.notFound().build();
    //     }
    //     return ResponseEntity.ok(mileStoneCatagorys);
    
    // }


    @PostMapping
    public ResponseEntity<mileStoneCatagory> addMileStoneCategory(@RequestBody mileStoneCatagory mileStoneCatagorys) {
        Users loggedInUser = currentlyLoggedInUser.getUser();
        mileStoneCatagorys.setOrganization(loggedInUser.getOrganization());
        assignCategory(mileStoneCatagorys);
        mileStoneCatagory savedmileStoneCategorys = mileStoneCatagoryRepositories.save(mileStoneCatagorys);
        return new ResponseEntity<>(savedmileStoneCategorys, HttpStatus.CREATED);
    }

    @PutMapping("/edit/{mileStoneCatagoryId}")
    public ResponseEntity<mileStoneCatagory> updateMileStoneCategory(@PathVariable Long mileStoneCatagoryId,
            @RequestBody mileStoneCatagory updatedMileStoneCategory) {
        mileStoneCatagory mileStoneCatagorys = mileStoneCatagoryRepositories
                .findMileStoneCatagoryByMileStoneCatagoryId(mileStoneCatagoryId);
        mileStoneCatagorys.setName(updatedMileStoneCategory.getName());
        mileStoneCatagorys.setValue(updatedMileStoneCategory.getValue());
        assignCategory(mileStoneCatagorys);
        mileStoneCatagory savedMileStoneCategorys = mileStoneCatagoryRepositories.save(mileStoneCatagorys);
        return new ResponseEntity<>(savedMileStoneCategorys, HttpStatus.OK);
    }

    private void assignCategory(mileStoneCatagory mileStoneCategorys) {
        double value = mileStoneCategorys.getValue();
        if (value >= 1000 && value <= 5000) {
            mileStoneCategorys.setCategory("Bronze");
        } else if (value >= 5001 && value <= 10000) {
            mileStoneCategorys.setCategory("Gold");
        } else if (value >= 10001 && value <= 20000) {
            mileStoneCategorys.setCategory("Silver");
        } else if (value > 20000) {
            mileStoneCategorys.setCategory("Platinum");
        }
    }

}
