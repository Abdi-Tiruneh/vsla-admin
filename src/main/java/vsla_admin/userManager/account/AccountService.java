package vsla_admin.userManager.account;

import vsla_admin.userManager.dto.ChangePassword;
import vsla_admin.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    ResponseEntity<ApiResponse> changePassword(ChangePassword changePassword);

}
