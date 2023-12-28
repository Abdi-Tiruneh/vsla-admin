package vsla_admin.mileCateagory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/mileStoneCatagory")
@RequiredArgsConstructor

public class mileStoneCatagoryController {

    @Autowired
    private final mileStoneCatagoryService mileStoneCatagoryServices;
     private final mileStoneCatagoryRepository mileStoneCatagoryRepositories;
  

   @GetMapping("/{mileStoneCatagoryId}")
   public ResponseEntity<String> getmileStoneCatagoryById(@PathVariable Long mileStoneCatagoryId) {
    mileStoneCatagory mileStoneCatagorys = mileStoneCatagoryRepositories.findMileStoneCatagoryByMileStoneCatagoryId(mileStoneCatagoryId);
    if (mileStoneCatagorys != null) {
        int value = mileStoneCatagorys.getValue();
        String category = mileStoneCatagoryServices.getCatagory(value);
        return ResponseEntity.ok(category);
     } else {
            return ResponseEntity.notFound().build();

        }
    }
   }   


    