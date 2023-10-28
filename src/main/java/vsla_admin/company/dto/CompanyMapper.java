package vsla_admin.company.dto;

import vsla_admin.company.Company;
import vsla_admin.userManager.dto.UserResponse;
import vsla_admin.userManager.user.Users;

public class CompanyMapper {
    public static CompanyResponse toCompanyResponse(Company company) {

        Users users = company.getRegisteredBy();
        UserResponse registeredBy = UserResponse.builder()
                .userId(users.getUserId())
                .fullName(users.getFullName())
                .role(users.getRole().getRoleName())
                .build();

        return CompanyResponse.builder()
                .companyId(company.getCompanyId())
                .companyName(company.getCompanyName())
                .enabled(company.isEnabled())
                .companyStatus(company.getCompanyStatus())
                .address(company.getAddress())
                .registeredBy(registeredBy)
                .createdAt(company.getCreatedAt())
                .updatedAt(company.getUpdatedAt())
                .build();
    }
}

