package vsla_admin.mileCateagory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface mileStoneCatagoryRepository extends JpaRepository<mileStoneCatagory, Long> {

     mileStoneCatagory findMileStoneCatagoryByMileStoneCatagoryId(Long mileStoneCatagoryId);


    
}



