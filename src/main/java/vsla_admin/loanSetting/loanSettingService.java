package vsla_admin.loanSetting;

import java.util.List;

public interface loanSettingService {
    loanSetting addLoanSetting(loanSetting loanSettings);
    loanSetting editLoanSetting(loanSetting loanSettings);
    List<loanSetting> getloanSetting();
    loanSetting getLoanSettingByLoanSettingId(Long loanSettingId);
    
}
