package vsla_admin.groupSetting;

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

@Getter
@Setter
@Entity
@RequiredArgsConstructor

public class GroupSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groupSettingId;
    private Double minGroupMember;
    private Double maxGroupMember;
    private Double minPayableAmount;
    private Double maxPayableAmount;
    private String status;
    private Boolean isActive;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "organization_id")
    private Organization organization;

}
