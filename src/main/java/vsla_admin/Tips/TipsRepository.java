package vsla_admin.Tips;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vsla_admin.organization.organization.Organization;

@Repository

public interface TipsRepository extends JpaRepository <Tips, Long> {

    Tips findTipsByTipsId(Long TipsId);
    List<Tips> findTipsByOrganization(Organization organization);
    
}
