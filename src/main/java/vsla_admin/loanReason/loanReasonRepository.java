package vsla_admin.loanReason;

import org.springframework.data.jpa.repository.JpaRepository;

public interface loanReasonRepository extends JpaRepository< loanReason, Long> {
    loanReason findLoanReasonByLoanReasonId(Long loanReasonId);

    
} 