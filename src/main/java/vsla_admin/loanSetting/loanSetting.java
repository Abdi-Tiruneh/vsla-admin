package vsla_admin.loanSetting;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Data

public class loanSetting {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long loanSettingId;
private Double maxLoan;
private Double loanPeriod;
private Double loanPerYear;
private Double loanInterest;
private Double paymentInterval;

}



