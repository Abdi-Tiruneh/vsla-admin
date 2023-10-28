package vsla_admin.company.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import vsla_admin.address.dto.AddressReq;

@Data
public class CompanyRegistrationReq {

    @NotBlank(message = "Company Name is required")
    private String companyName;

    @NotNull(message = "Address is required")
    private AddressReq address;

}