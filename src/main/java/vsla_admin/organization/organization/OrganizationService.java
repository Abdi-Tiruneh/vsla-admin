package vsla_admin.organization.organization;


import vsla_admin.organization.organization.dto.OrganizationRegistration;
import vsla_admin.organization.organization.dto.OrganizationResponse;
import vsla_admin.organization.organization.dto.OrganizationUpdate;

import java.util.List;

public interface OrganizationService {
    OrganizationResponse createOrganization(OrganizationRegistration registrationReq);

    OrganizationResponse updateOrganization(Long organizationId, OrganizationUpdate updateReq);

    List<OrganizationResponse> getAllOrganizations();

    OrganizationResponse getOrganizationById(Long organizationId);

    Organization getById(Long organizationId);

    void deleteOrganization(Long organizationId);
}
