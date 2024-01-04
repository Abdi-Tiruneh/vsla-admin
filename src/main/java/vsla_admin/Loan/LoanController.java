package vsla_admin.Loan;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import vsla_admin.userManager.user.Users;
import vsla_admin.utils.CurrentlyLoggedInUser;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/Loan")
@Tag(name = "Loan-Api")
public class LoanController {
     private final LoanFeignClient loanFeignClient;
    private final CurrentlyLoggedInUser currentlyLoggedInUser;
    @GetMapping("/AdminLoanPage")
    public ResponseEntity<?> getAllMeetingIntervals() {
        Users loggedInUser = currentlyLoggedInUser.getUser();
        return loanFeignClient.getAllLoanData(loggedInUser.getOrganization().getOrganizationId());
    }
}
