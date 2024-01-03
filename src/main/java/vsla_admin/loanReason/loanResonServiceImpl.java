package vsla_admin.loanReason;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import vsla_admin.exceptions.customExceptions.UnauthorizedException;
import vsla_admin.userManager.user.Users;
import vsla_admin.utils.CurrentlyLoggedInUser;

@RequiredArgsConstructor
@Service

public class LoanResonServiceImpl implements LoanReasonSevice{

    @Autowired
    private final LoanReasonRepository loanReasonRepositories;
    private final CurrentlyLoggedInUser currentlyLoggedInUser;  

    @Override
    public LoanReason editLoanReason(LoanReason loanReason) {
          Users loggedInUser = currentlyLoggedInUser.getUser();
      if(loggedInUser.getOrganization().getOrganizationId().compareTo(loanReason.getOrganization().getOrganizationId())!=0)
      {
        throw new UnauthorizedException("user is not authorized");
      }
      else{
          return loanReasonRepositories.save(loanReason);
      }
     
       
    }

    @Override
    public List<LoanReason> getloanReasons() {
      Users loggedInUser = currentlyLoggedInUser.getUser();
      return loanReasonRepositories.findLoanReasonByOrganization(loggedInUser.getOrganization());
    }

    @Override
    public LoanReason getLoanReasonByLoanReasonId(Long loanReasonId) {
      return loanReasonRepositories.findLoanReasonByLoanReasonId(loanReasonId);
    }

  

    @Override
    public LoanReason addLoanReason(LoanReason loanReason) {
    return loanReasonRepositories.save(loanReason);
    }

     @DeleteMapping("/delete/loanReason/{loanReasonId}")
  void deleteLoanReason(@PathVariable Long loanReasonId) {
    this.loanReasonRepositories.deleteById(loanReasonId);
  }
    
}
