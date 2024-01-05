package vsla_admin.Tips;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import vsla_admin.exceptions.customExceptions.UnauthorizedException;
import vsla_admin.loanReason.LoanReason;
import vsla_admin.organization.organization.Organization;
import vsla_admin.organization.organization.OrganizationRepository;
import vsla_admin.userManager.user.Users;
import vsla_admin.utils.CurrentlyLoggedInUser;

@Service
@RequiredArgsConstructor
public class TipServiceImpl implements TipsService {
  @Autowired
  private final TipsRepository tipsRepository;
  private final CurrentlyLoggedInUser currentlyLoggedInUser;
  private final OrganizationRepository organizationRepository;

  @Override
  public List<Tips> getTips() {
    Users loggedInUser = currentlyLoggedInUser.getUser();
    return tipsRepository.findTipsByOrganizationAndIsActive(loggedInUser.getOrganization(), true);

  }

  @Override
  public Tips getTipsByTipsId(Long TipsId) {
    return tipsRepository.findTipsByTipsId(TipsId);
  }

  @Override
  public Tips editTips(Tips tips) {
    Users loggedInUser = currentlyLoggedInUser.getUser();
    if (loggedInUser.getOrganization().getOrganizationId()
        .compareTo(tips.getOrganization().getOrganizationId()) != 0) {
      throw new UnauthorizedException("user is not authorized");
    } else {
      return tipsRepository.save(tips);
    }

  }

  @Override
  public Tips addTips(Tips tips) {
    return tipsRepository.save(tips);
  }

  @Override
  public Tips deleteTips(Long tipsId) {
    Tips deleteTips = tipsRepository.findTipsByTipsId(tipsId);
    deleteTips.setIsActive(false);
    tipsRepository.save(deleteTips);
    return deleteTips;

  }

  @Override
  public List<Tips> getTipsForApp(Long organizationId) {
    Organization organization=organizationRepository.findByOrganizationId(organizationId);
    return tipsRepository.findTipsByOrganizationAndIsActive(organization, true);
  }

}