package vsla_admin.company;


import vsla_admin.company.dto.CompanyRegistrationReq;
import vsla_admin.company.dto.CompanyResponse;
import vsla_admin.company.dto.CompanyUpdateReq;

import java.util.List;

public interface CompanyService {
    CompanyResponse createCompany(CompanyRegistrationReq registrationReq);

    CompanyResponse updateCompany(Long companyId, CompanyUpdateReq updateReq);

    List<CompanyResponse> getAllCompanies();

    CompanyResponse getCompanyById(Long companyId);

    void deleteCompany(Long companyId);
}
