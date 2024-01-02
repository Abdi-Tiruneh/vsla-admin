package vsla_admin.loanReason;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity

public class LoanReason {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long loanReasonId;
    private String title;
    private String loanDescription;

}
