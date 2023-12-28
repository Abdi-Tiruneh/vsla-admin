package vsla_admin.loanReason;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class loanResonServiceImpl implements loanReasonSevice{

    @Autowired
    private final loanReasonRepository loanReasonRepositories;

    @Override
    public loanReason editLoanReason(loanReason loanReasons) {
        return loanReasonRepositories.save(loanReasons);
       
    }

    @Override
    public List<loanReason> getloanReasons() {
      return loanReasonRepositories.findAll();
    }

    @Override
    public loanReason getLoanReasonByLoanReasonId(Long loanReasonId) {
      return loanReasonRepositories.findLoanReasonByLoanReasonId(loanReasonId);
    }
    
}
