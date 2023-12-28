package vsla_admin.loanSetting;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class loanSettingServiceImp implements loanSettingService{
    private final loanSettingRepository loanSettingRepositories;

    @Override
    public loanSetting addLoanSetting(loanSetting loanSettings) {
     return loanSettingRepositories.save(loanSettings);
    }

    @Override
    public loanSetting editLoanSetting(loanSetting loanSettings) {
        return loanSettingRepositories.save(loanSettings);
    }

    @Override
    public List<loanSetting> getloanSetting() {
       return loanSettingRepositories.findAll();
    }

    @Override
    public loanSetting getLoanSettingByLoanSettingId(Long loanSettingId) {
      return loanSettingRepositories.findLoanSettingByLoanSettingId(loanSettingId);
    }
    
}
