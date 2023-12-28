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

public class loanReason {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long loanReasonId;
    private String loanDescription;
}
