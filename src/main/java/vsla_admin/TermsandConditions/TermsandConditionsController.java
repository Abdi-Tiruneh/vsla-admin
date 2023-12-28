package vsla_admin.TermsandConditions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import vsla_admin.Response.createResponse;

@RestController
@RequestMapping("api/v1/TermsandConditions")
@RequiredArgsConstructor

public class TermsandConditionsController {

    @Autowired
    private final TermsandConditionsService termsandConditionsService;

     @PostMapping("/add")
    public ResponseEntity<createResponse> addTermsandConditions (@RequestBody TermsandConditions termsandConditions) {
        termsandConditionsService.addTermsandConditions(termsandConditions);
        createResponse response = new createResponse("success", "TermsandConditions created sucessfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getTermsandConditions")
    List<TermsandConditions> getTermsandConditions() {
        return this.termsandConditionsService.getTermsandConditions();
    }

    // @GetMapping("/{TermsandConditionsId}")
    // TermsandConditions getTermsandConditions(@PathVariable Long TermsandConditionsId) {
    //     return termsandConditionsService.getTermsandConditionsByTermsandConditionsId(TermsandConditionsId);
    // }

//    @PutMapping("/edit/{TermsandConditionsId}")
//    TermsandConditions editTermsandConditions(@RequestBody TermsandConditions tempTermsandConditions, @PathVariable Long TermsandConditionsId){
//    TermsandConditions termsandConditions= this.termsandConditionsService.getTermsandConditionsByTermsandConditionsId(TermsandConditionsId);
//    termsandConditions.setTitle(tempTermsandConditions.getTitle());
//    termsandConditions.setDescription(tempTermsandConditions.getDescription());
//    return termsandConditionsService.editTermsandConditions(termsandConditions);
//    }


    
}
