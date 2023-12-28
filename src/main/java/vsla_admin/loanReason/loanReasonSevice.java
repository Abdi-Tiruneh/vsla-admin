package vsla_admin.loanReason;

import java.util.List;

public interface loanReasonSevice {
    
    loanReason editLoanReason( loanReason loanReasons);
    List<loanReason> getloanReasons();
    loanReason getLoanReasonByLoanReasonId(Long loanReasonId);
     
}
