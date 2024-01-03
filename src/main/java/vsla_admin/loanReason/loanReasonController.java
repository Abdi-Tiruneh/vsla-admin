package vsla_admin.loanReason;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;
import vsla_admin.Response.createResponse;
import vsla_admin.Tips.Tips;
import vsla_admin.loanSetting.loanSetting;
import vsla_admin.userManager.user.Users;
import vsla_admin.utils.CurrentlyLoggedInUser;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/loanReason")

public class LoanReasonController {
    @Autowired
    private final LoanReasonSevice loanReasonSevices;
    private final LoanReasonRepository loanReasonRepositories;

    private final CurrentlyLoggedInUser currentlyLoggedInUser;

    @PostMapping("/add")
    // public ResponseEntity<createResponse> addLoanReason (@RequestBody LoanReason
    // loanReasonss) {
    // loanReasonSevices.addLoanReason(loanReasonss);
    // createResponse response = new createResponse("success", "LoanReason created
    // sucessfully");
    // return new ResponseEntity<>(response, HttpStatus.OK);
    // }
    LoanReason addLoanReason(@RequestBody LoanReason loanReasons) {
        Users loggedInUser = currentlyLoggedInUser.getUser();
        loanReasons.setOrganization(loggedInUser.getOrganization());
        loanReasonSevices.addLoanReason(loanReasons);
        return loanReasonSevices.addLoanReason(loanReasons);
    }

    @GetMapping("/getloanReasons")
    List<LoanReason> getloanReasons() {
        return loanReasonSevices.getloanReasons();

    }

    @GetMapping("/{loanReasonId}")
    LoanReason getLoanReason(@PathVariable Long loanReasonId) {
        return loanReasonSevices.getLoanReasonByLoanReasonId(loanReasonId);
    }

    @PutMapping("/edit/{loanReasonId}")
    LoanReason editLoanReason(@RequestBody LoanReason tempLoanReason, @PathVariable Long loanReasonId) {
        LoanReason loanReasons = this.loanReasonSevices.getLoanReasonByLoanReasonId(loanReasonId);
        loanReasons.setLoanDescription(tempLoanReason.getLoanDescription());
        loanReasons.setTitle(tempLoanReason.getTitle());
        return loanReasonSevices.editLoanReason(loanReasons);

    }

         @DeleteMapping("/delete/{loanReasonId}")
  void deleteLoanReason(@PathVariable Long loanReasonId) {
    this.loanReasonRepositories.deleteById(loanReasonId);
  }

}
