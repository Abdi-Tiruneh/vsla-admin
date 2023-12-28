package vsla_admin.TermsandConditions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor


public class TermsandConditionsServiceImpl implements TermsandConditionsService {
    @Autowired
    private final TermsandConditionsRepository TermsandConditionsRepositories;

    @Override
    public TermsandConditions addTermsandConditions(TermsandConditions termsandConditions) {
      return TermsandConditionsRepositories.save(termsandConditions);
    }

    @Override
    public TermsandConditions editTermsandConditions(TermsandConditions termsandConditions) {
       return TermsandConditionsRepositories.save(termsandConditions);
    }

    @Override
    public List<TermsandConditions> getTermsandConditions() {
      return TermsandConditionsRepositories.findAll();
    }

    // @Override
    // public TermsandConditions getTermsandConditionsByTermsandConditionsId(Long TermsandConditionsId) {
    //   return TermsandConditionsRepositories.findTermsandConditionsByTermsandConditionsId(TermsandConditionsId);
    // }

  

    
}
