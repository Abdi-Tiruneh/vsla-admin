package vsla_admin.awareness;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AwarenessRepository extends JpaRepository<Awareness, Long> {
    List<Awareness> findByOrganizationOrganizationId(Long organizationId);
}