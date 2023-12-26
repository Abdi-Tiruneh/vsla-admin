package vsla_admin.organization.organization.dto;

import lombok.Data;
import vsla_admin.address.Address;

@Data
public class OrganizationUpdate {

    private String organizationName;

    private Address address;
}
