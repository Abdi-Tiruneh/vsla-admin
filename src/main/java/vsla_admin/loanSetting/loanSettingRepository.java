package vsla_admin.loanSetting;

import org.springframework.data.jpa.repository.JpaRepository;

public interface loanSettingRepository extends JpaRepository<loanSetting, Long> {
    
       loanSetting findLoanSettingByLoanSettingId(Long loanSettingId);
}
