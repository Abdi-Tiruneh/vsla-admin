package vsla_admin.Loan;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Loan", url = "${VSLA_APP.BASE_URL}" + "Loan")
public interface LoanFeignClient {

    @GetMapping("/AdminLoanPage/{organizationId}")
    ResponseEntity<?> getAllLoanData(@PathVariable Long organizationId);
    
} 