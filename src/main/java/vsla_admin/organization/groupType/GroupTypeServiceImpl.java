package vsla_admin.organization.groupType;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vsla_admin.exceptions.customExceptions.ResourceNotFoundException;
import vsla_admin.organization.groupType.dto.GroupTypeReq;
import vsla_admin.userManager.user.Users;
import vsla_admin.utils.CurrentlyLoggedInUser;
import vsla_admin.utils.Status;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupTypeServiceImpl implements GroupTypeService {
    private final GroupTypeRepository groupTypeRepository;
    private final CurrentlyLoggedInUser currentlyLoggedInUser;

    @Override
    public GroupType createGroupType(GroupTypeReq groupTypeReq) {
        Users loggedInUser = currentlyLoggedInUser.getUser();

        // Create a new Project
        GroupType groupType = new GroupType();
        groupType.setGroupTypeName(groupTypeReq.getGroupTypeName());
        groupType.setStatus(Status.ACTIVE);
        groupType.setOrganization(loggedInUser.getOrganization());

        return groupTypeRepository.save(groupType);
    }

    @Override
    public GroupType updateGroupType(Long groupTypeId, GroupTypeReq groupTypeReq) {
        GroupType groupType = getById(groupTypeId);

        if (groupTypeReq.getGroupTypeName() != null)
            groupType.setGroupTypeName(groupTypeReq.getGroupTypeName());

        return groupTypeRepository.save(groupType);
    }

    @Override
    public List<GroupType> getAllGroupTypesByOrganization(Long organizationId) {
        return groupTypeRepository.findByOrganizationOrganizationId(organizationId);
    }

    @Override
    public void deleteGroupType(Long groupTypeId) {
        getById(groupTypeId);
        groupTypeRepository.deleteById(groupTypeId);
    }

    private GroupType getById(Long groupTypeId) {
        return groupTypeRepository.findById(groupTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with ID: " + groupTypeId));
    }
}
