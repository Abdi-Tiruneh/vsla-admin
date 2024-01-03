package vsla_admin.mileCateagory;

import org.springframework.data.jpa.repository.JpaRepository;

import vsla_admin.organization.organization.Organization;

public interface mileStoneCatagoryRepository extends JpaRepository<mileStoneCatagory, Long> {

     mileStoneCatagory findMileStoneCatagoryByMileStoneCatagoryId(Long mileStoneCatagoryId);
     mileStoneCatagory findMileStoneCatagoryByOrganization(Organization organization);


    
}



