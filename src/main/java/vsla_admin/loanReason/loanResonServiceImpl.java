package vsla_admin.loanReason;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class LoanResonServiceImpl implements LoanReasonSevice{

    @Autowired
    private final LoanReasonRepository loanReasonRepositories;

    @Override
    public LoanReason editLoanReason(LoanReason loanReason) {
        return loanReasonRepositories.save(loanReason);
       
    }

    @Override
    public List<LoanReason> getloanReasons() {
      return loanReasonRepositories.findAll();
    }

    @Override
    public LoanReason getLoanReasonByLoanReasonId(Long loanReasonId) {
      return loanReasonRepositories.findLoanReasonByLoanReasonId(loanReasonId);
    }

  

    @Override
    public LoanReason addLoanReason(LoanReason loanReason) {
    return loanReasonRepositories.save(loanReason);
    }
    
}
