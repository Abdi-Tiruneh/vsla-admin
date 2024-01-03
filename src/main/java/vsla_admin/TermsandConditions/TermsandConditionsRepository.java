package vsla_admin.TermsandConditions;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vsla_admin.organization.organization.Organization;


public interface TermsandConditionsRepository extends JpaRepository<TermsandConditions, Long> {

      TermsandConditions findTermsandConditionsByTermsandConditionsId( Long termsandConditionsId);
      List<TermsandConditions> findTermsandConditionsByOrganizationAndIsActive(Organization organization, Boolean isActive);
   

    
}
