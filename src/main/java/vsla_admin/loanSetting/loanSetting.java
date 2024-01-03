package vsla_admin.loanSetting;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import vsla_admin.organization.organization.Organization;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class loanSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long loanSettingId;
    private Double maxLoan;
    private Double loanPeriod;
    private Double loanPerYear;
    private Double loanInterest;
    private Double paymentInterval;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "organization_id")
    private Organization organization;

}
