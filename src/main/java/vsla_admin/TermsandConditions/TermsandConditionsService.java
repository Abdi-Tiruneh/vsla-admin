package vsla_admin.TermsandConditions;

import java.util.List;

public interface TermsandConditionsService {
    TermsandConditions addTermsandConditions(TermsandConditions termsandConditions);

    TermsandConditions editTermsandConditions(TermsandConditions termsandConditions);

    List<TermsandConditions> getTermsandConditions();

    List<TermsandConditions> getTermsAndConditionsForApp(Long organizationId);

    TermsandConditions getTermsandConditionsByTermsandConditionsId(Long termsandConditionsId);

}
