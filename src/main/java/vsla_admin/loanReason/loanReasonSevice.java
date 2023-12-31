package vsla_admin.loanReason;

import java.util.List;

public interface LoanReasonSevice {
    
    LoanReason editLoanReason( LoanReason loanReasons);
    List<LoanReason> getloanReasons();
    List<LoanReason> getloanReasonsForApp(Long organizationId);
    LoanReason getLoanReasonByLoanReasonId(Long loanReasonId);
    LoanReason addLoanReason( LoanReason loanReason);
    LoanReason  deleteLoanReason( Long loanReasonId);
     
}






