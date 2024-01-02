package vsla_admin.loanReason;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanReasonRepository extends JpaRepository< LoanReason, Long> {
    LoanReason findLoanReasonByLoanReasonId(Long loanReasonId);

    
} 