package vsla_admin.loanSetting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import vsla_admin.userManager.user.Users;
import vsla_admin.utils.CurrentlyLoggedInUser;

@RestController
@RequestMapping("/api/v1/loanSetting")
@RequiredArgsConstructor

public class loanSettingController {
    @Autowired
    private final loanSettingService loanSettingServices;
    private final CurrentlyLoggedInUser currentlyLoggedInUser;

    @PostMapping("/add")

    loanSetting addLoanSetting(@RequestBody loanSetting loanSettings) {
        Users loggedInUser = currentlyLoggedInUser.getUser();
        loanSettings.setOrganization(loggedInUser.getOrganization());
        loanSettingServices.addLoanSetting(loanSettings);
        // public ResponseEntity<createResponse> addLoanSetting (@RequestBody
        // loanSetting loanSettings) {
        // createResponse response = new createResponse("success", "loanSetting created
        // sucessfully");
        // return new ResponseEntity<>(response, HttpStatus.OK);
        return loanSettingServices.addLoanSetting(loanSettings);
    }

    @GetMapping("/getloanSetting")
    List<loanSetting> loanSetting() {
        return this.loanSettingServices.getloanSetting();
    }

    @GetMapping("/{loanSettingId}")
    loanSetting getLoanSetting(@PathVariable Long loanSettingId) {
        return loanSettingServices.getLoanSettingByLoanSettingId(loanSettingId);
    }

    @PutMapping("/edit/{loanSettingId}")
    loanSetting editLoanSetting(@RequestBody loanSetting tempLoanSetting, @PathVariable Long loanSettingId) {
        loanSetting loansettings = this.loanSettingServices.getLoanSettingByLoanSettingId(loanSettingId);
        loansettings.setMaxLoan(tempLoanSetting.getMaxLoan());
        loansettings.setLoanPeriod(tempLoanSetting.getLoanPeriod());
        loansettings.setLoanPerYear(tempLoanSetting.getLoanPerYear());
        loansettings.setLoanInterest(tempLoanSetting.getLoanInterest());
        loansettings.setPaymentInterval(tempLoanSetting.getPaymentInterval());
        return loanSettingServices.editLoanSetting(loansettings);

    }

}
