package vsla_admin.loanReason;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vsla_admin.organization.organization.Organization;

public interface LoanReasonRepository extends JpaRepository< LoanReason, Long> {
    LoanReason findLoanReasonByLoanReasonId(Long loanReasonId);
      List<LoanReason> findLoanReasonByOrganization(Organization organization);

    
} 