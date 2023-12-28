package vsla_admin.loanReason;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/loanReason")

public class loanReasonController {
    @Autowired
    private final loanReasonSevice loanReasonSevices;

    @GetMapping("/getloanReasons")
    List<loanReason> getloanReasons(){
        return loanReasonSevices.getloanReasons();
        
    } 

    @GetMapping("/{loanReasonId}")
    loanReason getLoanReason(@PathVariable Long loanReasonId) {
        return loanReasonSevices.getLoanReasonByLoanReasonId(loanReasonId);
    }

    @PutMapping("/edit/{loanReasonId}")
    loanReason editLoanReason(@RequestBody loanReason tempLoanReason, @PathVariable Long loanReasonId) {
        loanReason loanReasons = this.loanReasonSevices.getLoanReasonByLoanReasonId(loanReasonId);
        loanReasons.setLoanDescription(tempLoanReason.getLoanDescription());
        return loanReasonSevices.editLoanReason(loanReasons);

    }

   
    }

    

