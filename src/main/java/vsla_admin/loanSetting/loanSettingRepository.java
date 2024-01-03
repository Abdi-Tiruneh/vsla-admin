package vsla_admin.loanSetting;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vsla_admin.organization.organization.Organization;

public interface loanSettingRepository extends JpaRepository<loanSetting, Long> {
    
       loanSetting findLoanSettingByLoanSettingId(Long loanSettingId);
       List<loanSetting> findLoanSettingByOrganizationAndIsActive(Organization organization , Boolean isActive);
}
