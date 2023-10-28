package vsla_admin.company;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vsla_admin.address.Address;
import vsla_admin.address.AddressService;
import vsla_admin.company.dto.CompanyMapper;
import vsla_admin.company.dto.CompanyRegistrationReq;
import vsla_admin.company.dto.CompanyResponse;
import vsla_admin.company.dto.CompanyUpdateReq;
import vsla_admin.exceptions.customExceptions.ResourceNotFoundException;
import vsla_admin.userManager.user.UserRepository;
import vsla_admin.userManager.user.Users;
import vsla_admin.utils.CurrentlyLoggedInUser;
import vsla_admin.utils.Status;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CurrentlyLoggedInUser currentlyLoggedInUser;
    private final AddressService addressService;

    private final UserRepository userRepository;

    @Override
    @Transactional
    public CompanyResponse createCompany(CompanyRegistrationReq registrationReq) {
        // Retrieve the currently logged-in user
        Users loggedInUser = currentlyLoggedInUser.getUser();

        // Check if the user is already belongs to some company
        if (loggedInUser.getCompany() != null)
            throw new IllegalArgumentException("You are currently affiliated with the '" +
                    loggedInUser.getCompany().getCompanyName() + "' company.");

        // Create an address for the group
        Address address = addressService.createAddress(registrationReq.getAddress());

        // Create a new Company
        Company company = new Company();
        company.setCompanyName(registrationReq.getCompanyName());
        company.setCompanyStatus(Status.PENDING);
        company.setAddress(address);
        company.setRegisteredBy(loggedInUser);

        company = companyRepository.save(company);

        // Update the user's company
        updateUser(loggedInUser, company);

        return CompanyMapper.toCompanyResponse(company);
    }

    private void updateUser(Users user, Company company) {
        user.setCompany(company);
        userRepository.save(user);
    }


    @Override
    public CompanyResponse updateCompany(Long companyId, CompanyUpdateReq updateReq) {
        Company company = getById(companyId);

        if (updateReq.getCompanyName() != null)
            company.setCompanyName(updateReq.getCompanyName());

        if (updateReq.getAddress() != null) {
            Address address = addressService.updateAddress(company.getAddress(), updateReq.getAddress());
            company.setAddress(address);
        }

        return CompanyMapper.toCompanyResponse(companyRepository.save(company));
    }

    @Override
    public List<CompanyResponse> getAllCompanies() {
        List<Company> companies = companyRepository.findAll(Sort.by(Sort.Order.asc("companyId")));
        return companies.stream()
                .map(CompanyMapper::toCompanyResponse)
                .toList();
    }

    @Override
    public CompanyResponse getCompanyById(Long companyId) {
        Company company = getById(companyId);
        return CompanyMapper.toCompanyResponse(company);
    }

    @Override
    public void deleteCompany(Long companyId) {
        getById(companyId);
        companyRepository.deleteById(companyId);
    }

    public Company getById(Long companyId) {
        return companyRepository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found with ID: " + companyId));
    }

}
