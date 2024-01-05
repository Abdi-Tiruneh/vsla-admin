package vsla_admin.mileCateagory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vsla_admin.groupSetting.GroupSetting;
import vsla_admin.userManager.user.Users;
import vsla_admin.utils.CurrentlyLoggedInUser;

@Service
@RequiredArgsConstructor
public class mileStoneCategoryServiceImpl implements mileStoneCatagoryService {

  @Autowired
  private final mileStoneCatagoryRepository mileStoneCatagoryRepositories;
  private final CurrentlyLoggedInUser currentlyLoggedInUser;

  @Override
  public List<mileStoneCatagory> getMileStoneCatagory() {
    Users loggedInUser = currentlyLoggedInUser.getUser();
    
    // return
    // mileStoneCatagoryRepositories.findMileStoneCatagoryByOrganizationAndIsActive(loggedInUser.getOrganization(),
    // true);

    return mileStoneCatagoryRepositories.findMileStoneCatagoryByOrganization(loggedInUser.getOrganization());
  }

}
