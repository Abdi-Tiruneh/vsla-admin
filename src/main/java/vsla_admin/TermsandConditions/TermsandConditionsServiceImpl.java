package vsla_admin.TermsandConditions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vsla_admin.exceptions.customExceptions.UnauthorizedException;
import vsla_admin.userManager.user.Users;
import vsla_admin.utils.CurrentlyLoggedInUser;

@Service
@RequiredArgsConstructor

public class TermsandConditionsServiceImpl implements TermsandConditionsService {
  @Autowired
  private final TermsandConditionsRepository TermsandConditionsRepositories;
  private final CurrentlyLoggedInUser currentlyLoggedInUser;

  @Override
  public TermsandConditions addTermsandConditions(TermsandConditions termsandConditions) {

    return TermsandConditionsRepositories.save(termsandConditions);

  }

  @Override
  public TermsandConditions editTermsandConditions(TermsandConditions termsandConditions) {

    Users loggedInUser = currentlyLoggedInUser.getUser();
    if (loggedInUser.getOrganization().getOrganizationId()
        .compareTo(termsandConditions.getOrganization().getOrganizationId()) != 0) {
      throw new UnauthorizedException("user is not authorized");
    } else {
      return TermsandConditionsRepositories.save(termsandConditions);
    }
  }

  @Override
  public List<TermsandConditions> getTermsandConditions() {
    Users loggedInUser = currentlyLoggedInUser.getUser();
    return TermsandConditionsRepositories.findTermsandConditionsByOrganization(loggedInUser.getOrganization());
  }

  @Override
  public TermsandConditions getTermsandConditionsByTermsandConditionsId(Long termsandConditionsId) {
    return TermsandConditionsRepositories.findTermsandConditionsByTermsandConditionsId(termsandConditionsId);
  }

}
