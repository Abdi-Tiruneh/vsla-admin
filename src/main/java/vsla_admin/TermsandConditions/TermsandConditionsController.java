package vsla_admin.TermsandConditions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;
import vsla_admin.userManager.user.Users;
import vsla_admin.utils.CurrentlyLoggedInUser;

@RestController
@RequestMapping("api/v1/TermsandConditions")
@RequiredArgsConstructor

public class TermsandConditionsController {

    @Autowired
    private final TermsandConditionsService termsandConditionsService;
    private final CurrentlyLoggedInUser currentlyLoggedInUser;

     @PostMapping("/add")
    // public ResponseEntity<createResponse> addTermsandConditions (@RequestBody TermsandConditions termsandConditions) {
    //     termsandConditionsService.addTermsandConditions(termsandConditions);
    //     createResponse response = new createResponse("success", "TermsandConditions created sucessfully");
    //     return new ResponseEntity<>(response, HttpStatus.OK);
    // }

        TermsandConditions addTermsandConditions(@RequestBody TermsandConditions termsandConditions){
             Users loggedInUser = currentlyLoggedInUser.getUser();
             termsandConditions.setOrganization(loggedInUser.getOrganization());
             termsandConditionsService.addTermsandConditions(termsandConditions);
             return termsandConditionsService.addTermsandConditions(termsandConditions);
        }

    @GetMapping("/getTermsandConditions")
    List<TermsandConditions> getTermsandConditions() {
        return this.termsandConditionsService.getTermsandConditions();
    }

    @GetMapping("/getTermsandConditions/App/{organizationId}")
    List<TermsandConditions> getTermsAndConditionsForApp(@PathVariable Long organizationId) {
        return this.termsandConditionsService.getTermsAndConditionsForApp(organizationId);
    }

    @GetMapping("/{termsandConditionsId}")
    TermsandConditions getTermsandConditions(@PathVariable Long termsandConditionsId) {
        return termsandConditionsService.getTermsandConditionsByTermsandConditionsId(termsandConditionsId);
    }

   @PutMapping("/edit/{termsandConditionsId}")
   TermsandConditions editTermsandConditions(@RequestBody TermsandConditions tempTermsandConditions, @PathVariable Long termsandConditionsId){
   TermsandConditions termsandConditions= this.termsandConditionsService.getTermsandConditionsByTermsandConditionsId(termsandConditionsId);
   termsandConditions.setTitle(tempTermsandConditions.getTitle());
   termsandConditions.setDescription(tempTermsandConditions.getDescription());
   return termsandConditionsService.editTermsandConditions(termsandConditions);
   }


    
}
