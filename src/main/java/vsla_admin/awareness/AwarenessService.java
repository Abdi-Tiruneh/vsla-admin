package vsla_admin.awareness;


import vsla_admin.awareness.dto.AwarenessReq;

import java.util.List;

public interface AwarenessService {
    Awareness createAwareness(AwarenessReq awarenessReq);

    Awareness updateAwareness(Long id, AwarenessReq awarenessReq);

    List<Awareness> getAllAwarenessByOrganization(Long organizationId);

    List<Awareness> getAllAwarenessByOrganization();

    Awareness getAwarenessById(Long id);

    void deleteAwareness(Long id);
}
