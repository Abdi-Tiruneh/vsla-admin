package vsla_admin.company.dto;

import lombok.Data;
import vsla_admin.address.Address;

@Data
public class CompanyUpdateReq {

    private String companyName;

    private Address address;
}
