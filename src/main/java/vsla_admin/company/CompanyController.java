package vsla_admin.company;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vsla_admin.company.dto.CompanyRegistrationReq;
import vsla_admin.company.dto.CompanyResponse;
import vsla_admin.company.dto.CompanyUpdateReq;
import vsla_admin.utils.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/companies")
@Tag(name = "Company API.")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<CompanyResponse> createCompany(@RequestBody @Valid CompanyRegistrationReq registrationReq) {
        CompanyResponse createdStore = companyService.createCompany(registrationReq);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStore);
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<CompanyResponse> updateCompany(
            @PathVariable Long companyId, @RequestBody @Valid CompanyUpdateReq updateReq) {
        return ResponseEntity.ok(companyService.updateCompany(companyId, updateReq));
    }

    @GetMapping
    public ResponseEntity<List<CompanyResponse>> getAllCompanies() {
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyResponse> getCompanyById(@PathVariable Long companyId) {
        return ResponseEntity.ok(companyService.getCompanyById(companyId));
    }

    @DeleteMapping({"/{userId}"})
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long userId) {
        companyService.deleteCompany(userId);
        return ApiResponse.success("Company deleted successfully");
    }


}

