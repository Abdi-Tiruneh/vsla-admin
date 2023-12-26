package vsla_admin.organization.organization;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vsla_admin.address.Address;
import vsla_admin.address.AddressService;
import vsla_admin.exceptions.customExceptions.ResourceNotFoundException;
import vsla_admin.organization.organization.dto.OrganizationRegistration;
import vsla_admin.organization.organization.dto.OrganizationResponse;
import vsla_admin.organization.organization.dto.OrganizationUpdate;
import vsla_admin.userManager.user.UserRepository;
import vsla_admin.userManager.user.Users;
import vsla_admin.utils.CurrentlyLoggedInUser;
import vsla_admin.utils.Status;

import java.util.List;


@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationRepository organizationRepository;
    private final CurrentlyLoggedInUser currentlyLoggedInUser;
    private final AddressService addressService;

    private final UserRepository userRepository;

    @Override
    @Transactional
    public OrganizationResponse createOrganization(OrganizationRegistration registrationReq) {
        // Retrieve the currently logged-in user
        Users loggedInUser = currentlyLoggedInUser.getUser();

        // Create an address for the group
        Address address = addressService.createAddress(registrationReq.getAddress());

        // Create a new Project
        Organization organization = new Organization();
        organization.setOrganizationName(registrationReq.getOrganizationName());
        organization.setOrganizationStatus(Status.PENDING);
        organization.setAddress(address);
        organization.setRegisteredBy(loggedInUser);

        organization = organizationRepository.save(organization);
        return OrganizationResponse.toResponse(organization);
    }

    @Override
    public OrganizationResponse updateOrganization(Long organizationId, OrganizationUpdate updateReq) {
        Organization organization = getById(organizationId);

        if (updateReq.getOrganizationName() != null)
            organization.setOrganizationName(updateReq.getOrganizationName());

        if (updateReq.getAddress() != null) {
            Address address = addressService.updateAddress(organization.getAddress(), updateReq.getAddress());
            organization.setAddress(address);
        }

        return OrganizationResponse.toResponse(organizationRepository.save(organization));
    }

    @Override
    public List<OrganizationResponse> getAllOrganizations() {
        List<Organization> organizations = organizationRepository.findAll(Sort.by(Sort.Order.asc("organizationId")));
        return organizations.stream()
                .map(OrganizationResponse::toResponse)
                .toList();
    }

    @Override
    public OrganizationResponse getOrganizationById(Long organizationId) {
        Organization organization = getById(organizationId);
        return OrganizationResponse.toResponse(organization);
    }


    @Override
    public void deleteOrganization(Long organizationId) {
        getById(organizationId);
        organizationRepository.deleteById(organizationId);
    }

    @Override
    public Organization getById(Long organizationId) {
        return organizationRepository.findById(organizationId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with ID: " + organizationId));
    }

}
