package vsla_admin.Tips;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TipsRepository extends JpaRepository <Tips, Long> {

    Tips findTipsByTipsId(Long TipsId);
    
}
