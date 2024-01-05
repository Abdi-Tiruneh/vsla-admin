package vsla_admin.mileCateagory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vsla_admin.groupSetting.GroupSetting;
import vsla_admin.organization.organization.Organization;

public interface mileStoneCatagoryRepository extends JpaRepository<mileStoneCatagory, Long> {

     mileStoneCatagory findMileStoneCatagoryByMileStoneCatagoryId(Long mileStoneCatagoryId);
     List<mileStoneCatagory>findMileStoneCatagoryByOrganization(Organization organization);



    
}



