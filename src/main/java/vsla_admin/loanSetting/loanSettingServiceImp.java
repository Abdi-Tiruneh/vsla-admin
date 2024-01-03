package vsla_admin.loanSetting;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vsla_admin.exceptions.customExceptions.UnauthorizedException;
import vsla_admin.userManager.user.Users;
import vsla_admin.utils.CurrentlyLoggedInUser;

@Service
@RequiredArgsConstructor

public class loanSettingServiceImp implements loanSettingService{
    private final loanSettingRepository loanSettingRepositories;
    private final CurrentlyLoggedInUser currentlyLoggedInUser;

    @Override
    public loanSetting addLoanSetting(loanSetting loanSettings) {
     return loanSettingRepositories.save(loanSettings);
    }

    @Override
    public loanSetting editLoanSetting(loanSetting loanSettings) {
        Users loggedInUser = currentlyLoggedInUser.getUser();
      if(loggedInUser.getOrganization().getOrganizationId().compareTo(loanSettings.getOrganization().getOrganizationId())!=0)
      {
        throw new UnauthorizedException("user is not authorized");
      }
      else{
           return loanSettingRepositories.save(loanSettings);
      }
       
    }

    @Override
    public List<loanSetting> getloanSetting() {
       Users loggedInUser = currentlyLoggedInUser.getUser();
       return loanSettingRepositories.findLoanSettingByOrganizationandIsActive(loggedInUser.getOrganization(), true);
    }


    @Override
    public loanSetting getLoanSettingByLoanSettingId(Long loanSettingId) {
      return loanSettingRepositories.findLoanSettingByLoanSettingId(loanSettingId);
    }
    
}
