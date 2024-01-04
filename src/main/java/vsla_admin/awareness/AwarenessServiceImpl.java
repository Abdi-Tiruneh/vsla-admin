package vsla_admin.awareness;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vsla_admin.awareness.dto.AwarenessReq;
import vsla_admin.exceptions.customExceptions.ResourceNotFoundException;
import vsla_admin.fileUploadManager.FileUploadService;
import vsla_admin.utils.CurrentlyLoggedInUser;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class AwarenessServiceImpl implements AwarenessService {
    private final AwarenessRepository awarenessRepository;
    private final CurrentlyLoggedInUser currentlyLoggedInUser;
    private final FileUploadService fileUploadService;

    @Override
    public List<Awareness> createAwareness(AwarenessReq awarenessReq) {
        List<Awareness> awarenesses= new ArrayList<Awareness>();
        String imageUrl = fileUploadService.uploadFile(awarenessReq.getImage());
        awarenessReq.getGroups().stream().forEach(g->{
            Awareness awareness = new Awareness();
        awareness.setTitle(awarenessReq.getTitle());
        awareness.setDescription(awarenessReq.getDescription());
        awareness.setImageUrl(imageUrl);
        awareness.setVideoUrl(awarenessReq.getVideoUrl());
        awareness.setOrganization(currentlyLoggedInUser.getUser().getOrganization());
        awareness.setGroupId(g.getGroupId());
        awarenessRepository.save(awareness);
        awarenesses.add(awareness);
        });
        return awarenesses;
    }

    @Override
    public Awareness updateAwareness(Long id, AwarenessReq awarenessReq) {
        Awareness awareness = getAwarenessById(id);

        if (awarenessReq.getTitle() != null)
            awareness.setTitle(awarenessReq.getTitle());

        if (awarenessReq.getDescription() != null)
            awareness.setDescription(awarenessReq.getDescription());

        if (awarenessReq.getVideoUrl() != null)
            awareness.setVideoUrl(awarenessReq.getVideoUrl());

        if (awarenessReq.getImage() != null) {
            String imageUrl = fileUploadService.uploadFile(awarenessReq.getImage());
            awareness.setImageUrl(imageUrl);
        }

        return awarenessRepository.save(awareness);
    }

    //for user app
    @Override
    public List<Awareness> getAllAwarenessByOrganization(Long organizationId) {
        return awarenessRepository.findByOrganizationOrganizationId(organizationId);
    }

    //for admin
    @Override
    public List<Awareness> getAllAwarenessByOrganization() {
        Long organizationId = currentlyLoggedInUser.getUser().getOrganization().getOrganizationId();
        return awarenessRepository.findByOrganizationOrganizationId(organizationId);
    }


    @Override
    public Awareness getAwarenessById(Long id) {
        return awarenessRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Awareness not found with id: " + id));
    }

    @Override
    public void deleteAwareness(Long id) {
        getAwarenessById(id);
        awarenessRepository.deleteById(id);
    }

    @Override
    public List<Awareness> getAllAwarenessByGroupId(Long groupId) {
        return awarenessRepository.findByGroupId(groupId);
    }
}
